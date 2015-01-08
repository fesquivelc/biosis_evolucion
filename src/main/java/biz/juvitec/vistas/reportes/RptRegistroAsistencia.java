/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.juvitec.vistas.reportes;

import biz.juvitec.controladores.PeriodoControlador;
import biz.juvitec.entidades.Empleado;
import biz.juvitec.entidades.Periodo;
import biz.juvitec.vistas.modelos.MTEmpleado;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author RyuujiMD
 */
public class RptRegistroAsistencia extends javax.swing.JInternalFrame {

    /**
     * Creates new form RptRegistroAsistencia
     */
    public RptRegistroAsistencia() {
        initComponents();
        pc = new PeriodoControlador();
        
        FormularioUtil.modeloSpinnerFechaHora(spFechaInicio, "dd/MM/yyyy");
        FormularioUtil.modeloSpinnerFechaHora(spFechaFin, "dd/MM/yyyy");
        inicializar();
        bindeoSalvaje();
        controles();
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

        grpTipoReporte = new javax.swing.ButtonGroup();
        grpRango = new javax.swing.ButtonGroup();
        grpSeleccion = new javax.swing.ButtonGroup();
        pnlOpciones = new javax.swing.JPanel();
        radConsolidado = new javax.swing.JRadioButton();
        radDetallado = new javax.swing.JRadioButton();
        chkMarcaciones = new javax.swing.JCheckBox();
        pnlRango = new javax.swing.JPanel();
        radPorFecha = new javax.swing.JRadioButton();
        radMes = new javax.swing.JRadioButton();
        radAnio = new javax.swing.JRadioButton();
        spFechaInicio = new javax.swing.JSpinner();
        spFechaFin = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        cboMes = new com.toedter.calendar.JMonthChooser();
        cboPeriodo = new javax.swing.JComboBox();
        cboPeriodo1 = new javax.swing.JComboBox();
        pnlEmpleados = new javax.swing.JPanel();
        radOficina = new javax.swing.JRadioButton();
        radGrupo = new javax.swing.JRadioButton();
        radPersonalizado = new javax.swing.JRadioButton();
        cboGrupoHorario = new javax.swing.JComboBox();
        txtOficina = new javax.swing.JTextField();
        btnOficina = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new org.jdesktop.swingx.JXTable();
        pnlBotones = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        grpTipoReporte.add(radConsolidado);
        grpTipoReporte.add(radDetallado);

        grpRango.add(radPorFecha);
        grpRango.add(radMes);
        grpRango.add(radAnio);

        grpSeleccion.add(radGrupo);
        grpSeleccion.add(radOficina);
        grpSeleccion.add(radPersonalizado);

        setClosable(true);
        setTitle("REPORTE DE REGISTRO DE ASISTENCIA");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de reporte"));
        pnlOpciones.setLayout(new java.awt.GridBagLayout());

        radConsolidado.setSelected(true);
        radConsolidado.setText("Reporte consolidado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlOpciones.add(radConsolidado, gridBagConstraints);

        radDetallado.setText("Reporte detallado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlOpciones.add(radDetallado, gridBagConstraints);

        chkMarcaciones.setText("Mostrar marcaciones no procesadas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlOpciones.add(chkMarcaciones, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(pnlOpciones, gridBagConstraints);

        pnlRango.setBorder(javax.swing.BorderFactory.createTitledBorder("Rango"));
        pnlRango.setLayout(new java.awt.GridBagLayout());

        radPorFecha.setSelected(true);
        radPorFecha.setText("Por fechas:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(radPorFecha, gridBagConstraints);

        radMes.setText("Por mes:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(radMes, gridBagConstraints);

        radAnio.setText("Por año:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(radAnio, gridBagConstraints);

        spFechaInicio.setModel(new javax.swing.SpinnerDateModel());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(spFechaInicio, gridBagConstraints);

        spFechaFin.setModel(new javax.swing.SpinnerDateModel());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(spFechaFin, gridBagConstraints);

        jLabel1.setText("-");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        pnlRango.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlRango.add(cboMes, gridBagConstraints);

        cboPeriodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(cboPeriodo, gridBagConstraints);

        cboPeriodo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlRango.add(cboPeriodo1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(pnlRango, gridBagConstraints);

        pnlEmpleados.setBorder(javax.swing.BorderFactory.createTitledBorder("Selección de empleados"));
        pnlEmpleados.setLayout(new java.awt.GridBagLayout());

        radOficina.setText("Por oficina:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radOficina, gridBagConstraints);

        radGrupo.setText("Por grupo horario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radGrupo, gridBagConstraints);

        radPersonalizado.setSelected(true);
        radPersonalizado.setText("Personalizado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(radPersonalizado, gridBagConstraints);

        cboGrupoHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlEmpleados.add(cboGrupoHorario, gridBagConstraints);

        txtOficina.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlEmpleados.add(txtOficina, gridBagConstraints);

        btnOficina.setText("...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnlEmpleados.add(btnOficina, gridBagConstraints);

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTabla);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        pnlEmpleados.add(jScrollPane1, gridBagConstraints);

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

        jButton2.setText("GENERAR REPORTE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlBotones.add(jButton2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        getContentPane().add(pnlBotones, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOficina;
    private javax.swing.JComboBox cboGrupoHorario;
    private com.toedter.calendar.JMonthChooser cboMes;
    private javax.swing.JComboBox cboPeriodo;
    private javax.swing.JComboBox cboPeriodo1;
    private javax.swing.JCheckBox chkMarcaciones;
    private javax.swing.ButtonGroup grpRango;
    private javax.swing.ButtonGroup grpSeleccion;
    private javax.swing.ButtonGroup grpTipoReporte;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlEmpleados;
    private javax.swing.JPanel pnlOpciones;
    private javax.swing.JPanel pnlRango;
    private javax.swing.JRadioButton radAnio;
    private javax.swing.JRadioButton radConsolidado;
    private javax.swing.JRadioButton radDetallado;
    private javax.swing.JRadioButton radGrupo;
    private javax.swing.JRadioButton radMes;
    private javax.swing.JRadioButton radOficina;
    private javax.swing.JRadioButton radPersonalizado;
    private javax.swing.JRadioButton radPorFecha;
    private javax.swing.JSpinner spFechaFin;
    private javax.swing.JSpinner spFechaInicio;
    private org.jdesktop.swingx.JXTable tblTabla;
    private javax.swing.JTextField txtOficina;
    // End of variables declaration//GEN-END:variables

    private List<Empleado> empleadoList;
    private List<Periodo> periodoList;
    private final PeriodoControlador pc;
    
    private void inicializar() {
        empleadoList = ObservableCollections.observableList(new ArrayList<Empleado>());
        periodoList = pc.buscarTodosOrden();
    }

    private void controles() {               
        FormularioUtil.activarComponente(chkMarcaciones, radDetallado.isSelected());
        
        FormularioUtil.activarComponente(spFechaInicio, radPorFecha.isSelected());
        FormularioUtil.activarComponente(spFechaFin, radPorFecha.isSelected());
        FormularioUtil.activarComponente(cboMes, radMes.isSelected());
        FormularioUtil.activarComponente(cboPeriodo1, radMes.isSelected());
        FormularioUtil.activarComponente(cboPeriodo, radAnio.isSelected());

        FormularioUtil.activarComponente(cboGrupoHorario, radGrupo.isSelected());
        FormularioUtil.activarComponente(btnOficina, radGrupo.isSelected());
        FormularioUtil.activarComponente(tblTabla, radPersonalizado.isSelected());

    }

    private void bindeoSalvaje() {
        MTEmpleado mt = new MTEmpleado(empleadoList);
        tblTabla.setModel(mt);

        
        JComboBoxBinding binding = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, periodoList, cboPeriodo);
        binding.bind();

        DefaultListCellRenderer render = new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                if (value != null) {
                    if (value instanceof Periodo) {
                        value = ((Periodo)value).getNombre();
                    }
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }

        };
        
        cboPeriodo.setRenderer(render);
    }
}
