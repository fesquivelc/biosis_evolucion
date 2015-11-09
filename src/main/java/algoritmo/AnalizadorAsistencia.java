/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import com.personal.utiles.FechaUtil;
import controladores.AsignacionHorarioControlador;
import controladores.ContratoControlador;
import controladores.FeriadoControlador;
import controladores.MarcacionControlador;
import controladores.PermisoControlador;
import controladores.VacacionControlador;
import controladores.sisgedo.BoletaControlador;
import entidades.AsignacionHorario;
import entidades.DetalleJornada;
import entidades.Feriado;
import entidades.Marcacion;
import entidades.Permiso;
import entidades.Turno;
import entidades.Vacacion;
import entidades.asistencia.Asistencia;
import entidades.asistencia.DetalleAsistencia;
import entidades.escalafon.Contrato;
import entidades.escalafon.Empleado;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 *
 * @author Francis
 */
public class AnalizadorAsistencia {
    /*
     VALORES PARA COMPARAR EN LA ASISTENCIA
     */

    static final int NINGUNO = 0;
    public static final int PERMISO_FECHA = 1;
    public static final int FERIADO = 2;
    public static final int VACACION = 3;
    static final int PERMISO_HORA = 4;
    static final int ASISTENCIA = 5;
    /*
     RESULTADOS DE ASISTENCIA
     */
    public static final int REGULAR = 0;
    public static final int TARDANZA = -1;
    public static final int FALTA = -2;
    /*
     LISTADOS QUE CONTIENEN LA INFORMACION TANTO DE FERIADOS, PERMISOS Y VACACIONES PARA EL EMPLEADO
     */
    private List<Feriado> feriadoList;
    private List<Permiso> permisoList;
    private List<Vacacion> vacacionList;
    /*
     LISTADO DE LAS MARCACIONES DEL EMPLEADO
     */
    private List<Marcacion> marcacionList;
    /*
     CONTROLADORES
     */
    private final AsignacionHorarioControlador asghorc = new AsignacionHorarioControlador();
    private final BoletaControlador bolc = BoletaControlador.getInstance();
    private final ContratoControlador contc = ContratoControlador.getInstance();
    private final FeriadoControlador ferc = new FeriadoControlador();
    private final PermisoControlador permc = new PermisoControlador();
    private final VacacionControlador vacc = new VacacionControlador();
    private final MarcacionControlador marc = new MarcacionControlador();

    private final AnalizadorDiario analizadorDiario = new AnalizadorDiario();

    public List<Asistencia> analizarAsistencia(List<Empleado> empleadoList, Date fechaInicio, Date fechaFin) {
        List<Asistencia> asistenciaList = new ArrayList<>();
        cargarFeriados(fechaInicio, fechaFin);
//        Object objetoPermiso;
//        int tipoPermiso;
        empleadoList.stream().forEach(empleado -> {
            cargarSalidas(empleado, fechaInicio, fechaFin);
            cargarVacaciones(empleado, fechaInicio, fechaFin);
            List<Contrato> contratos = contc.obtenerContratosXFechas(empleado, fechaInicio, fechaFin);
            Date desde1 = fechaInicio;
            Date hasta1 = fechaFin;

            this.cargarMarcaciones(empleado, desde1, hasta1);
            this.analizadorDiario.setMarcaciones(marcacionList);

            List<AsignacionHorario> asignaciones = asghorc.buscarXEmpleado(empleado, desde1, hasta1);

            asignaciones.stream().forEach(asignacion -> {
                Date desde2 = desde1.before(asignacion.getFechaInicio()) ? asignacion.getFechaInicio() : desde1;
                Date hasta2 = hasta1.before(asignacion.getFechaFin()) ? hasta1 : asignacion.getFechaFin();

                Calendar iteradorDia = Calendar.getInstance();
                iteradorDia.setTime(desde2);

                Permiso permisoXFecha = null;
                Vacacion vacacion = null;
                List<Turno> turnos = asignacion.getHorario().getTurnoList();
                System.out.println("EMPLEADO: "+empleado.getNombreCompleto()+" TURNOS: ");
                turnos.stream().forEach(t -> System.out.println(String.format("ID: %s JORNADA: %s",t.getId(), t.getJornada().getNombre())));
                while (iteradorDia.getTime().compareTo(hasta2) <= 0) {
//                    if(objetoPermiso == null){
                    vacacion = this.buscarVacacion(iteradorDia.getTime());
                    if (vacacion == null) {
                        permisoXFecha = this.buscarPermisoXFecha(iteradorDia.getTime());
                        if (permisoXFecha == null) {
                            if (isDiaLaboral(iteradorDia.getTime(), turnos)) {
                                Feriado feriado = this.buscarFeriado(iteradorDia.getTime());
                                if (feriado == null) {
                                    asistenciaList.addAll(this.generarAsistencia(
                                            empleado,
                                            iteradorDia.getTime(),
                                            turnos.stream().filter(t -> this.isDiaLaboral(iteradorDia.getTime(), t)).collect(Collectors.toList())));
                                } else {
                                    asistenciaList.add(this.generarAsistencia(empleado, iteradorDia.getTime(), feriado));
                                }
                            }
                        } else {
                            asistenciaList.add(this.generarAsistencia(empleado, iteradorDia.getTime(), permisoXFecha));

                        }
                    } else {
                        asistenciaList.add(this.generarAsistencia(empleado, iteradorDia.getTime(), vacacion));
                    }

                    iteradorDia.add(Calendar.DATE, 1);
                }

            });
        });

        return asistenciaList;
    }

    private List<DetalleAsistencia> desglosar(Turno turno) {
        List<DetalleAsistencia> desglose = new ArrayList<>();
        turno.getJornada().getDetalleJornadaList().forEach(detJorn -> {
            
            DetalleAsistencia detalle1 = new DetalleAsistencia();
            detalle1.setBandera(true);
            detalle1.setDiaSiguiente(false);
            detalle1.setHoraReferencia(detJorn.getEntrada());
            detalle1.setHoraReferenciaDesde(detJorn.getEntradaDesde());
            detalle1.setHoraReferenciaHasta(detJorn.getEntradaHasta());
            detalle1.setHoraReferenciaTolerancia(detJorn.getEntradaTolerancia());
            detalle1.setTipo('A');

            DetalleAsistencia detalle2 = new DetalleAsistencia();
            detalle2.setBandera(false);
            detalle2.setDiaSiguiente(detJorn.getSalida().before(detJorn.getEntrada()));
            detalle2.setHoraReferencia(detJorn.getSalida());
            detalle2.setHoraReferenciaDesde(detJorn.getSalidaDesde());
            detalle2.setHoraReferenciaHasta(detJorn.getSalidaHasta());
            detalle2.setTipo('A');

            desglose.add(detalle1);
            desglose.add(detalle2);
        });
        return desglose;
    }
    /*
    
    */
    private List<DetalleAsistencia> desglosar(List<Permiso> permisoList) {
        List<DetalleAsistencia> desglose = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        permisoList.stream().forEach(perm -> {
            
            DetalleAsistencia detalleI = new DetalleAsistencia();
            detalleI.setBandera(true);
            detalleI.setDiaSiguiente(false); //POR REVISAR
            detalleI.setHoraReferencia(perm.getHoraInicio());
            detalleI.setHoraReferenciaDesde(perm.getHoraInicio());
            cal.setTime(perm.getHoraInicio());
            cal.add(Calendar.MINUTE, 40); //VARIABLE
            detalleI.setHoraReferenciaHasta(cal.getTime());
            detalleI.setTipo('P');
            
            DetalleAsistencia detalleF = new DetalleAsistencia();
            detalleF.setBandera(false);
            detalleF.setDiaSiguiente(false); //POR REVISAR
            detalleF.setHoraReferencia(perm.getHoraFin());
            cal.add(Calendar.SECOND, 1);
            detalleF.setHoraReferenciaDesde(cal.getTime());
            detalleF.setMotivo(perm.getTipoPermiso().getNombre());
            
            desglose.add(detalleI);
            desglose.add(detalleF);
        });
        return desglose;
    }

    private void cargarVacaciones(Empleado empleado, Date fechaInicio, Date fechaFin) {
        this.vacacionList = vacc.buscarXEmpleadoEntreFecha(empleado, fechaInicio, fechaFin);
    }

    private void cargarFeriados(Date fechaInicio, Date fechaFin) {
        this.feriadoList = ferc.buscarXFechas(fechaInicio, fechaFin);
    }

    private void cargarSalidas(Empleado empleado, Date fechaInicio, Date fechaFin) {
        this.permisoList = permc.buscarXEmpleadoXFechaEntreFecha(empleado, fechaInicio, fechaFin);
    }

    private Feriado buscarFeriado(Date dia) {
        try {
            Feriado feriado = this.feriadoList
                    .stream()
                    .filter(fer -> fer.getFechaInicio().compareTo(dia) <= 0 && fer.getFechaFin().compareTo(dia) >= 0)
                    .findFirst()
                    .get();
            return feriado;
        } catch (NoSuchElementException e) {
            System.out.println("NO HAY FERIADOS EN ESTA FECHA");
            return null;
        }
    }

    private Vacacion buscarVacacion(Date dia) {
        try {
            Date soloFechaComparacion = FechaUtil.soloFecha(dia);
            Vacacion vacacion = this.vacacionList
                    .stream()
                    .filter(vac -> vac.getFechaInicio().compareTo(soloFechaComparacion) <= 0 && vac.getFechaFin().compareTo(soloFechaComparacion) >= 0)
                    .findFirst()
                    .get();
            return vacacion;
        } catch (NoSuchElementException e) {
            System.out.println("NO HAY FERIADOS EN ESTA FECHA");
            return null;
        }
    }

    private Permiso buscarPermisoXFecha(Date dia) {
        try {
            Date soloFechaComparacion = FechaUtil.soloFecha(dia);
            Permiso permiso = this.permisoList
                    .stream()
                    .filter(perm
                            -> perm.getFechaInicio().compareTo(soloFechaComparacion) <= 0 && perm.getFechaFin().compareTo(soloFechaComparacion) >= 0
                    )
                    .findFirst()
                    .get();
            return permiso;
        } catch (NoSuchElementException e) {
            System.out.println("NO HAY PERMISOS EN ESA FECHA");
            return null;
        }

    }

    private boolean isDiaLaboral(Date dia, List<Turno> turnos) {
        boolean resultado = false;
        for (Turno turno : turnos) {
            resultado = resultado || isDiaLaboral(dia, turno);
        }
        return resultado;
    }

    private boolean isDiaLaboral(Date fecha, Turno turno) {
        if (turno.getTipo() == 'S') {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);

            switch (cal.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.MONDAY:
                    return turno.isLunes();
                case Calendar.TUESDAY:
                    return turno.isMartes();
                case Calendar.WEDNESDAY:
                    return turno.isMiercoles();
                case Calendar.THURSDAY:
                    return turno.isJueves();
                case Calendar.FRIDAY:
                    return turno.isViernes();
                case Calendar.SATURDAY:
                    return turno.isSabado();
                case Calendar.SUNDAY:
                    return turno.isDomingo();
                default:
                    return false;
            }
        } else {
            return turno.getFechaInicio().compareTo(fecha) <= 0
                    && turno.getFechaFin().compareTo(fecha) >= 0;
        }
    }

    /*
     Genera un registro de asistencia para el permiso por fecha
     */
    private Asistencia generarAsistencia(Empleado empleado, Date dia, Permiso permisoXFecha) {
        Asistencia asistencia = new Asistencia();
        asistencia.setEmpleado(empleado);
        asistencia.setFecha(dia);
        asistencia.setResultado(PERMISO_FECHA);
        asistencia.setPermiso(permisoXFecha);
        return asistencia;
    }

    /*
     Genera un registro de asistencia para la vacacion
     */
    private Asistencia generarAsistencia(Empleado empleado, Date dia, Vacacion vacacion) {
        Asistencia asistencia = new Asistencia();
        asistencia.setEmpleado(empleado);
        asistencia.setFecha(dia);
        asistencia.setResultado(VACACION);
        asistencia.setVacacion(vacacion);
        return asistencia;
    }

    private Asistencia generarAsistencia(Empleado empleado, Date dia, Feriado feriado) {
        Asistencia asistencia = new Asistencia();
        asistencia.setEmpleado(empleado);
        asistencia.setFecha(dia);
        asistencia.setResultado(FERIADO);
        asistencia.setFeriado(feriado);
        return asistencia;
    }

    /*
     Genera un registro de asistencia para el análisis de los turnos
     */
    private List<Asistencia> generarAsistencia(Empleado empleado, Date dia, List<Turno> turnos) {
        /*
         Debemos realizar un análisis por turno buscando los permisos de cada uno
         */
        List<Asistencia> asistenciaList = new ArrayList<>();
        
        turnos.stream().forEach(turno -> {
            Asistencia asistencia = new Asistencia();
            asistencia.setPermisoList(this.desglosar(this.buscarPermisoXHora(empleado,dia)));
            asistencia.setFecha(dia);
            asistencia.setDetalleAsistenciaList(this.desglosar(turno));
            asistencia.setEmpleado(empleado);
            asistencia.setResultado(ASISTENCIA);
            analizadorDiario.setPermisos(asistencia.getPermisoList());
            analizadorDiario.setAsistencia(asistencia);
            analizadorDiario.iniciar();
            asistenciaList.add(asistencia);
        });

        return asistenciaList;
    }

    private void cargarMarcaciones(Empleado empleado, Date desde1, Date hasta1) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(hasta1);
        cal.add(Calendar.DATE, 1);

        this.marcacionList = this.marc.buscarXEmpleadoEntreFecha(empleado, desde1, cal.getTime());
    }

    private List<Permiso> buscarPermisoXHora(Empleado empleado, Date dia) {
        return this.permc.buscarPermisosPorHoraEnFecha(empleado, dia);
    }
}