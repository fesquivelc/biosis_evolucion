package vistas.reportes;

import algoritmo.AnalizadorAsistencia;
import algoritmo.Interprete;
import algoritmo.InterpreteResumen;
import controladores.DetalleGrupoControlador;
import controladores.EmpleadoControlador;
import controladores.GrupoHorarioControlador;
import controladores.PeriodoControlador;
import entidades.DetalleGrupoHorario;
import entidades.GrupoHorario;
import entidades.Periodo;
import vistas.dialogos.DlgEmpleado;
import vistas.modelos.MTEmpleado;
import com.personal.utiles.FormularioUtil;
import com.personal.utiles.ReporteUtil;
import com.personal.utiles.ReporteUtil.Formato;
import controladores.AreaEmpleadoControlador;
import controladores.MarcacionControlador;
import entidades.asistencia.Asistencia;
import entidades.escalafon.AreaEmpleado;
import entidades.escalafon.Departamento;
import entidades.escalafon.Empleado;
import entidades.reportes.RptAsistenciaDetallado;
import entidades.reportes.RptNoMarca;
import interpretes.InterpreteNoMarcacion;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;
import utiles.UsuarioActivo;
import vistas.dialogos.DlgOficina;
import javax.swing.JPanel;
import org.jdesktop.swingbinding.JTableBinding;
import principal.Main;
import utiles.HerramientaGeneral;
import vistas.dialogos.DlgMarcacionesDiarias;
import vistas.modelos.MTNoMarcan;

/**
 *
 * @author RyuujiMD
 */
public class RptNoMarcan extends javax.swing.JInternalFrame {

    /**
     * Creates new form RptRegistroAsistencia
     */
    private final ReporteUtil reporteador;
    private final DateFormat dfFecha;
    private final EmpleadoControlador ec;
    private final File archivo = new File("reportes/reporte_empleados_no_marcan.jasper");
    private final Font fuente;
    private final Interprete interprete = new InterpreteNoMarcacion();
    private final AreaEmpleadoControlador aempc = new AreaEmpleadoControlador();

    public RptNoMarcan() {
        initComponents();

        ec = new EmpleadoControlador();
        pc = new PeriodoControlador();
        dfFecha = new SimpleDateFormat("dd/MM/yyyy");
        reporteador = new ReporteUtil();
//        FormularioUtil.modeloSpinnerFechaHora(spFechaInicio, "dd/MM/yyyy");
//        FormularioUtil.modeloSpinnerFechaHora(spFechaFin, "dd/MM/yyyy");
        inicializar();
        bindeoSalvaje();
        controles();
        fuente = new Font(Font.SANS_SERIF, 0, 14);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        grpSeleccion = new javax.swing.ButtonGroup();
        pnlRango = new javax.swing.JPanel();
        radPorFecha = new javax.swing.JRadioButton();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        dcFechaFin = new com.toedter.calendar.JDateChooser();
        pnlEmpleados = new javax.swing.JPanel();
        radGrupo = new javax.swing.JRadioButton();
        radPersonalizado = new javax.swing.JRadioButton();
        cboGrupoHorario = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new org.jdesktop.swingx.JXTable();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        radOficina = new javax.swing.JRadioButton();
        txtOficina = new javax.swing.JTextField();
        btnOficina = new javax.swing.JButton();
        radTodos = new javax.swing.JRadioButton();
        pnlBotones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        pnlReporte = new javax.swing.JPanel();
        pnlTab = new javax.swing.JTabbedPane();
        tabDetallado = new javax.swing.JPanel();
        pnlOpciones = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAsistenciaDetallado = new org.jdesktop.swingx.JXTable();
        pnlCerrarTab = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        grpSeleccion.add(radGrupo);
        grpSeleccion.add(radPersonalizado);
        grpSeleccion.add(radOficina);
        grpSeleccion.add(radTodos);

        setClosable(true);
        setMaximizable(true);
        setTitle("REPORTE DE EMPLEADOS SIN MARCACIÓN");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlRango.setBorder(javax.swing.BorderFactory.createTitledBorder("Rango"));
        pnlRango.setLayout(new java.awt.GridBagLayout());

        radPorFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radPorFecha.setSelected(true);
        radPorFecha.setText("Fecha de ingreso:");
        radPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPorFechaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(radPorFecha, gridBagConstraints);

        dcFechaInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dcFechaInicioMouseReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(dcFechaInicio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlRango.add(dcFechaFin, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(pnlRango, gridBagConstraints);

        pnlEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección de empleados"));
        pnlEmpleados.setLayout(new java.awt.GridBagLayout());

        radGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radGrupo.setText("Por grupo horario:");
        radGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGrupoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radGrupo, gridBagConstraints);

        radPersonalizado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radPersonalizado.setText("Personalizado:");
        radPersonalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPersonalizadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radPersonalizado, gridBagConstraints);

        cboGrupoHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboGrupoHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboGrupoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboGrupoHorarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(cboGrupoHorario, gridBagConstraints);

        tblTabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(tblTabla);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlEmpleados.add(jScrollPane1, gridBagConstraints);

        btnAgregar.setText("+");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(btnAgregar, gridBagConstraints);

        btnQuitar.setText("-");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(btnQuitar, gridBagConstraints);

        radOficina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radOficina.setText("Por oficina:");
        radOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radOficinaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radOficina, gridBagConstraints);

        txtOficina.setEditable(false);
        txtOficina.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(txtOficina, gridBagConstraints);

        btnOficina.setText("...");
        btnOficina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOficinaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        pnlEmpleados.add(btnOficina, gridBagConstraints);

        radTodos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radTodos.setSelected(true);
        radTodos.setText("Todos");
        radTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radTodosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radTodos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(pnlEmpleados, gridBagConstraints);

        pnlBotones.setLayout(new java.awt.GridBagLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setText("GENERAR REPORTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBotones.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        getContentPane().add(pnlBotones, gridBagConstraints);

        pnlReporte.setLayout(new java.awt.BorderLayout());

        tabDetallado.setLayout(new java.awt.BorderLayout());

        pnlOpciones.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btnImprimir.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        pnlOpciones.add(btnImprimir);

        jButton4.setText("Ver marcaciones en el día");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlOpciones.add(jButton4);

        tabDetallado.add(pnlOpciones, java.awt.BorderLayout.PAGE_END);

        tblAsistenciaDetallado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAsistenciaDetallado.setHorizontalScrollEnabled(true);
        jScrollPane4.setViewportView(tblAsistenciaDetallado);

        tabDetallado.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        pnlTab.addTab("Detallado", tabDetallado);

        pnlReporte.add(pnlTab, java.awt.BorderLayout.CENTER);

        pnlCerrarTab.setLayout(new javax.swing.BoxLayout(pnlCerrarTab, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("Cerrar pestaña");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlCerrarTab.add(jButton1);

        pnlReporte.add(pnlCerrarTab, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        getContentPane().add(pnlReporte, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        generarReporte();
//        imprimir();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        DlgEmpleado dialogo = new DlgEmpleado(this);
        dialogo.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void radPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPorFechaActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radPorFechaActionPerformed

    private GrupoHorario grupoSeleccionado;
    private void cboGrupoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboGrupoHorarioActionPerformed
        // TODO add your handling code here:
        obtenerGrupo();
    }//GEN-LAST:event_cboGrupoHorarioActionPerformed

    private void radGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radGrupoActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radGrupoActionPerformed

    private void radPersonalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPersonalizadoActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radPersonalizadoActionPerformed

    private void radOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radOficinaActionPerformed
        // TODO add your handling code here:
        controles();
    }//GEN-LAST:event_radOficinaActionPerformed

    private void btnOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOficinaActionPerformed
        // TODO add your handling code here:
        DlgOficina oficinas = new DlgOficina(this);
        oficinaSeleccionada = oficinas.getSeleccionado();
        if (oficinaSeleccionada != null) {
            txtOficina.setText(oficinaSeleccionada.getNombre());

        }
    }//GEN-LAST:event_btnOficinaActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        int fila;
        if ((fila = tblTabla.getSelectedRow()) != -1) {
            empleadoList.remove(fila);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void radTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radTodosActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        if (!this.noMarcanList.isEmpty()) {
            imprimir();
        }
//        Formato formato = obtenerFormato();
//        String ruta;
//        ruta = FormularioUtil.guardarFichero(this, "Seleccione el destino donde guardará el resporte");
//        System.out.println("RUTA ENVIADA: "+ruta);
//        if (ruta.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Debe seleccionar un destino correcto", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
//        } else {
//            exportar(formato, ruta);
//        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.cerrarTabActivo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dcFechaInicioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dcFechaInicioMouseReleased
        // TODO add your handling code here:
        Date fechaSeleccionada = this.dcFechaInicio.getDate();
        if (fechaSeleccionada != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaSeleccionada);
            cal.add(Calendar.DATE, 1);
            this.dcFechaFin.setDate(cal.getTime());
        }


    }//GEN-LAST:event_dcFechaInicioMouseReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int fila = this.tblAsistenciaDetallado.getSelectedRow();
        if(fila != -1){
            RptNoMarca elemento = this.noMarcanList.get(fila);
            DlgMarcacionesDiarias marcaciones = new DlgMarcacionesDiarias(elemento.getEmpleado(), elemento.getFecha(), JOptionPane.getFrameForComponent(this));
            marcaciones.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private Departamento oficinaSeleccionada;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnOficina;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JComboBox cboGrupoHorario;
    private com.toedter.calendar.JDateChooser dcFechaFin;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.ButtonGroup grpSeleccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlCerrarTab;
    private javax.swing.JPanel pnlEmpleados;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlRango;
    private javax.swing.JPanel pnlReporte;
    private javax.swing.JTabbedPane pnlTab;
    private javax.swing.JRadioButton radGrupo;
    private javax.swing.JRadioButton radOficina;
    private javax.swing.JRadioButton radPersonalizado;
    private javax.swing.JRadioButton radPorFecha;
    private javax.swing.JRadioButton radTodos;
    private javax.swing.JPanel tabDetallado;
    private org.jdesktop.swingx.JXTable tblAsistenciaDetallado;
    private org.jdesktop.swingx.JXTable tblTabla;
    private javax.swing.JTextField txtOficina;
    // End of variables declaration//GEN-END:variables

    private List<Empleado> empleadoList;
    private List<Periodo> periodoList;
    private final PeriodoControlador pc;

    private void inicializar() {
//        JasperViewer jv = new JasperViewer(null);
//        pnlTab.add("Vista previa", jv.getContentPane());
        empleadoList = ObservableCollections.observableList(new ArrayList<Empleado>());
        periodoList = pc.buscarTodosOrden();
        grupoList = gc.buscarTodos();
    }

    private void controles() {
//        FormularioUtil.activarComponente(chkMarcaciones, radDetallado.isSelected());

        FormularioUtil.activarComponente(dcFechaInicio, radPorFecha.isSelected());
        FormularioUtil.activarComponente(dcFechaFin, false);
//        FormularioUtil.activarComponente(cboMes, radMes.isSelected());
//        FormularioUtil.activarComponente(cboPeriodo1, radMes.isSelected());
//        FormularioUtil.activarComponente(cboPeriodo, radAnio.isSelected());

        FormularioUtil.activarComponente(cboGrupoHorario, radGrupo.isSelected());
//        FormularioUtil.activarComponente(btnOficina, radGrupo.isSelected());
        FormularioUtil.activarComponente(tblTabla, radPersonalizado.isSelected());
        FormularioUtil.activarComponente(btnAgregar, radPersonalizado.isSelected());
        FormularioUtil.activarComponente(btnQuitar, radPersonalizado.isSelected());

        FormularioUtil.activarComponente(btnOficina, radOficina.isSelected());
    }

    private List<GrupoHorario> grupoList;

    private void bindeoSalvaje() {
        MTEmpleado mt = new MTEmpleado(empleadoList);
        this.mtNoMarcan = new MTNoMarcan(this.noMarcanList);
        tblTabla.setModel(mt);
        tblAsistenciaDetallado.setModel(this.mtNoMarcan);

        BindingGroup bindeo = new BindingGroup();

//        JComboBoxBinding binding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo);
//        JComboBoxBinding binding2 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo1);
        JComboBoxBinding binding3 = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, grupoList, cboGrupoHorario);
        JTableBinding bindeoDetalle = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, grupoList, tblAsistenciaDetallado);

//        bindeo.addBinding(binding);
//        bindeo.addBinding(binding2);
        bindeo.addBinding(binding3);
        bindeo.bind();

        DefaultListCellRenderer renderGrupo = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    if (value instanceof GrupoHorario) {
                        value = ((GrupoHorario) value).getNombre();
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }

        };
        DefaultListCellRenderer renderPeriodo = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    if (value instanceof Periodo) {
                        value = ((Periodo) value).getAnio();
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }

        };

//        tblAsistenciaDetallado.setDefaultRenderer(Date.class, new DefaultTableCellRenderer(){
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//                if(value != null){
//                    value = HerramientaGeneral.formatoHora.format((Date)value);
//                }
//                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
//            }
//            
//        });
//        cboPeriodo.setRenderer(renderPeriodo);
//        cboPeriodo1.setRenderer(renderPeriodo);
        cboGrupoHorario.setRenderer(renderGrupo);
    }
    private AnalizadorAsistencia analisis = new AnalizadorAsistencia();
    private final MarcacionControlador mc = new MarcacionControlador();
    private final List<RptNoMarca> noMarcanList = ObservableCollections.observableList(new ArrayList());
    private List<RptAsistenciaDetallado> asistenciaResumenList = ObservableCollections.observableList(new ArrayList());
    private MTNoMarcan mtNoMarcan;

    private void imprimir() {
        Map<String, Object> parametros = this.obtenerParametros();
        Component report = reporteador.obtenerReporte(this.noMarcanList, archivo, parametros);
//        pnlTab.removeTabAt(0);
        pnlTab.add("Vista previa " + pnlTab.getTabCount(), report);
        pnlTab.setSelectedIndex(pnlTab.getTabCount() - 1);
    }

    private Map<String, Object> obtenerParametros() {
        Calendar cal = Calendar.getInstance();

        String usuario = UsuarioActivo.getUsuario().getLogin();

        Date[] fechas = this.obtenerFechasLimite();
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("usuario", usuario);
        parametros.put("fecha_inicio", fechas[0]);
        parametros.put("fecha_fin", fechas[1]);
        parametros.put("reporte_ruc", Main.REPORTE_RUC);
        parametros.put("reporte_logo", Main.REPORTE_LOGO);
        parametros.put("reporte_institucion", Main.REPORTE_INSTITUCION);
        parametros.put("reporte_usuario", UsuarioActivo.getUsuario().getLogin());
        parametros.put("rangoValor", String.format("%s - %s", HerramientaGeneral.formatoFecha.format(fechas[0]), HerramientaGeneral.formatoFecha.format(fechas[1])));
//        parametros.put("mostrar_he", chkHFH.isSelected());

        return parametros;
    }

    boolean bandera = false;

    private List<Empleado> obtenerDNI() {

        List<Empleado> lista = new ArrayList<>();
        Date fechas[] = this.obtenerFechasLimite();
        if (radTodos.isSelected()) {
            lista = this.ec.buscarTodos();
        } else if (radGrupo.isSelected()) {
            obtenerGrupo();
            List<DetalleGrupoHorario> detalleGrupo = dgc.buscarXGrupo(grupoSeleccionado);
            for (DetalleGrupoHorario detalle : detalleGrupo) {
                lista.add(detalle.getEmpleado());
            }
        } else if (radPersonalizado.isSelected()) {
            for (Empleado empleado : empleadoList) {
                lista.add(empleado);
            }
        } else if (radOficina.isSelected()) {
            List<AreaEmpleado> areaEmpleadoList = aempc.buscarXEmpleadoXFecha(oficinaSeleccionada, fechas[0], fechas[1]);
            for (AreaEmpleado areaEmpleado : areaEmpleadoList) {
                lista.add(areaEmpleado.getEmpleado());
            }
//            List<FichaLaboral> fichas = oficinaSeleccionada.getFichaLaboralList();
//            for (FichaLaboral f : fichas) {
//                lista.add(f.getEmpleado());
//            }
        }

        return lista;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleadoList.add(empleado);
        tblTabla.packAll();
    }

    private GrupoHorarioControlador gc = new GrupoHorarioControlador();
    private DetalleGrupoControlador dgc = new DetalleGrupoControlador();

    private void obtenerGrupo() {
        int seleccionado = cboGrupoHorario.getSelectedIndex();
        if (seleccionado != -1) {
            grupoSeleccionado = this.grupoList.get(seleccionado);
        }
    }
//
//    private Formato obtenerFormato() {
//        int seleccionado = cboExportarFormato.getSelectedIndex();
//
//        switch (seleccionado) {
//            case 0:
//                return Formato.PDF;
//            case 1:
//                return Formato.XLSX;
//            case 2:
//                return Formato.XLS;
//            case 3:
//                return Formato.CSV;
//            case 4:
//                return Formato.DBF;
//            default:
//                return null;
//        }
//    }

    private void exportar(Formato formato, String ruta) {
        String reporte = "";
        File archivo = new File(reporte);
        Map<String, Object> parametros = this.obtenerParametros();
        if (formato != Formato.PDF) {
            parametros.put("MOSTRAR_TITULO", false);
        }
        reporteador.setConn(pc.getDao().getConexion());
        reporteador.exportarReporte(archivo, parametros, formato, ruta);
    }

    private List<Asistencia> asistenciaList;
    private Interprete interpreteResumen = new InterpreteResumen();

    private void generarReporte() {
        List<Empleado> empleados = obtenerDNI();
        Date[] fechasLimite = this.obtenerFechasLimite();
        asistenciaList = analisis.analizarAsistencia(empleados, fechasLimite[0], fechasLimite[1]);
        ((InterpreteNoMarcacion)this.interprete).setInicio(fechasLimite[0]);
        ((InterpreteNoMarcacion)this.interprete).setFin(fechasLimite[1]);
        System.out.println("ASISTENCIA LISt: " + asistenciaList.size());
        List<RptNoMarca> noMarcan = interprete.interpretar(asistenciaList);
        System.out.println("LUEGO DE INTERPRETAR: " + noMarcan.size());
        this.noMarcanList.clear();
        this.noMarcanList.addAll(noMarcan);
//        this.asistenciaDetalleList.addAll(asistenciaDetallado.stream().sorted((a1,a2) ->
//        {            
//            int comparacion = a1.getRegimenLaboral().compareTo(a2.getRegimenLaboral());
//            if(comparacion == 0){
//                comparacion = a1.getEmpleado().getNombreCompleto().compareTo(a2.getEmpleado().getNombreCompleto());
//                if(comparacion == 0){
//                    comparacion = a1.getFecha().compareTo(a2.getFecha());
//                }
//            }
//            return comparacion;
//        }).collect(Collectors.toList()));
//        this.asistenciaDetalleList.stream().forEach(asistencia -> System.out.println("--MES: "+asistencia.getMes()+" --"));
        this.tblAsistenciaDetallado.packAll();
    }

    private Date[] obtenerFechasLimite() {
        Calendar cal = Calendar.getInstance();
        Date[] fechas = new Date[2];
        int anio;
        int mes;
        Date fechaInicio = new Date();
        Date fechaFin = new Date();
        if (radPorFecha.isSelected()) {
            fechaInicio = dcFechaInicio.getDate();
            fechaFin = dcFechaFin.getDate();
        }
//        else if (radMes.isSelected()) {
//            anio = periodoList.get(cboPeriodo1.getSelectedIndex()).getAnio();
//            mes = cboMes.getMonth();
//            cal.set(anio, mes, 1);
//            fechaInicio = cal.getTime();
//            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
//            fechaFin = cal.getTime();
//        } else if (radAnio.isSelected()) {
//            anio = periodoList.get(cboPeriodo.getSelectedIndex()).getAnio();
//            cal.set(anio, 0, 1);
//            fechaInicio = cal.getTime();
//            cal.set(anio, 11, 31);
//            fechaFin = cal.getTime();
//        }

        fechas[0] = fechaInicio;

//        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaInicio);
        cal.add(Calendar.DATE, 1);
        fechaFin = cal.getTime();

        fechas[1] = fechaFin;

        return fechas;
    }

    private Component nuevoTab(Component reporte) {
        JPanel pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new BorderLayout());

        JPanel pnlCerrar = new JPanel();
        pnlCerrar.setLayout(new BoxLayout(pnlCerrar, BoxLayout.LINE_AXIS));

        JButton boton = new JButton();
        boton.setText("Cerrar pestaña");
        boton.setFont(fuente);
        boton.addActionListener((java.awt.event.ActionEvent evt) -> {
            cerrarTabActivo();
        });

        pnlCerrar.add(boton);

        pnlPrincipal.add(pnlCerrar, BorderLayout.NORTH);
        pnlPrincipal.add(reporte, BorderLayout.CENTER);

        return pnlPrincipal;
    }

    private void cerrarTabActivo() {
        int tabIndex = this.pnlTab.getSelectedIndex();
        if (tabIndex > 0) {
            this.pnlTab.remove(tabIndex);
        }

    }

//    private void imprimirResumen() {
//        File resumenFile = new File("reportes/reporte_asistencia_resumen.jasper");
//        
//        Map<String, Object> parametros = this.obtenerParametros();
//        Component report = reporteador.obtenerReporte(interpreteResumen.interpretar(asistenciaList), resumenFile, parametros);
////        pnlTab.removeTabAt(0);
//        pnlTab.add("Resumen "+pnlTab.getTabCount(), report);
//        pnlTab.setSelectedIndex(pnlTab.getTabCount()-1);
//    }
}
