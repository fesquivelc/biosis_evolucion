/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas.dialogos;

import com.personal.utiles.FechaUtil;
import com.personal.utiles.FormularioUtil;
import controladores.Controlador;
import controladores.biostar.EventoControlador;
import controladores.biostar.ReaderControlador;
import entidades.biostar.Evento;
import entidades.biostar.Reader;
import entidades.escalafon.Empleado;
import entidades.reportes.RptMarcacion;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import utiles.HerramientaGeneral;

/**
 *
 * @author Francis
 */
public class DlgAgregarMarcacion extends javax.swing.JDialog {

    /**
     * Creates new form DlgAgregarMarcacion
     */
    private Empleado empleado;
    private Date fecha;
    private final List<RptMarcacion> marcacionList;
    private final ReaderControlador readerc;
    private final EventoControlador eventoc;

    public DlgAgregarMarcacion(List<RptMarcacion> marcacionList, JInternalFrame owner, boolean modal) {
        super(JOptionPane.getFrameForComponent(owner), modal);
        initComponents();
        this.readerc = ReaderControlador.getInstance();
        this.eventoc = EventoControlador.getInstance();
        this.marcacionList = ObservableCollections.observableList(new ArrayList<>());
        bindeoSalvaje();
        this.marcacionList.addAll(marcacionList);
        mostrarDatos();
        this.setLocationRelativeTo(owner);

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

        jPanel1 = new javax.swing.JPanel();
        pnlBotones = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        pnlDatosEmpleado = new javax.swing.JPanel();
        lblEmpleado = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblEmpleado1 = new javax.swing.JLabel();
        cboEquipo = new javax.swing.JComboBox();
        pnlRegistros = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegistro = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AGREGAR MARCACIONES FALTANTES");
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        pnlBotones.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        jButton1.setText("Registrar evento");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlBotones.add(jButton1);

        jButton2.setText("Grabar cambios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlBotones.add(jButton2);

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlBotones.add(jButton3);

        jPanel1.add(pnlBotones, java.awt.BorderLayout.PAGE_END);

        java.awt.GridBagLayout pnlDatosEmpleadoLayout = new java.awt.GridBagLayout();
        pnlDatosEmpleadoLayout.columnWidths = new int[] {0, 5, 0};
        pnlDatosEmpleadoLayout.rowHeights = new int[] {0, 5, 0, 5, 0};
        pnlDatosEmpleado.setLayout(pnlDatosEmpleadoLayout);

        lblEmpleado.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblEmpleado.setText("Empleado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlDatosEmpleado.add(lblEmpleado, gridBagConstraints);

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblFecha.setText("Fecha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlDatosEmpleado.add(lblFecha, gridBagConstraints);

        lblEmpleado1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblEmpleado1.setText("Equipo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlDatosEmpleado.add(lblEmpleado1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlDatosEmpleado.add(cboEquipo, gridBagConstraints);

        jPanel1.add(pnlDatosEmpleado, java.awt.BorderLayout.PAGE_START);

        pnlRegistros.setBorder(javax.swing.BorderFactory.createTitledBorder("Registros faltantes"));
        pnlRegistros.setLayout(new java.awt.BorderLayout());

        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblRegistro);

        pnlRegistros.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlRegistros, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        /*
         CREAMOS ENTIDADES EVENTO Y GUARDAMOS
         */
        List<Evento> eventoList = new ArrayList<>();
        for (RptMarcacion rptMarcacion : this.marcacionList) {
            if (rptMarcacion.getEvento() != null) {
                Evento evento = new Evento();
                evento.setEmpleadoNroDocumento(Integer.parseInt(rptMarcacion.getEmpleado().getNroDocumento()));
                evento.setFechaHora(FechaUtil.unirFechaHora(rptMarcacion.getFecha(), rptMarcacion.getEvento()));
                evento.setEquipoID(((Reader) cboEquipo.getSelectedItem()).getId().intValue());
                eventoList.add(evento);
            }
        }

        boolean exito = true;
        int accion = Controlador.NUEVO;
        exito = eventoc.guardarLote(eventoList);

        if(exito){
            JOptionPane.showMessageDialog(this, "Se generaron los eventos exitosamente", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "No se pudieron generar los eventos", "Mensaje del sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int fila = this.tblRegistro.getSelectedRow();
        if (fila != -1) {
            RptMarcacion rptMarcacion = this.marcacionList.get(fila);
            DlgMarcacion dlgMarcacion = new DlgMarcacion(this, true, rptMarcacion);
            Date hora = dlgMarcacion.getHoraElegida();
            System.out.println("AGREGAR MARCACION 1: " + hora);
            rptMarcacion.setReferencia(hora);
            System.out.println("AGREGAR MARCACION 2: " + rptMarcacion.getEvento());
//            (tblRegistro.getModel()).fireTableDataChanged();
            bindeo.unbind();
            bindeo.bind();
            System.out.println("EVENTO: " + hora);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboEquipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblEmpleado1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDatosEmpleado;
    private javax.swing.JPanel pnlRegistros;
    private org.jdesktop.swingx.JXTable tblRegistro;
    // End of variables declaration//GEN-END:variables
    private BindingGroup bindeo;
    private List<Reader> readerList;

    private void bindeoSalvaje() {
        this.readerList = readerc.buscarTodos();
        System.out.println("READERS: "+this.readerList.size());
        JComboBoxBinding bindeoCombo = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, this.readerList, cboEquipo);
        bindeoCombo.bind();

        bindeo = new BindingGroup();

        JTableBinding bindeoTabla = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, marcacionList, tblRegistro);
        BeanProperty pHoraReferencia = BeanProperty.create("referencia");
        BeanProperty pHoraEvento = BeanProperty.create("evento");

        bindeoTabla.addColumnBinding(pHoraReferencia).setColumnClass(Date.class).setEditable(false).setColumnName("Hora referencia");
        bindeoTabla.addColumnBinding(pHoraEvento).setColumnClass(Date.class).setEditable(false).setColumnName("Hora de marcación");

        bindeo.addBinding(bindeoTabla);
        bindeo.bind();

        tblRegistro.setDefaultRenderer(Date.class, new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value != null) {
                    value = HerramientaGeneral.formatoHoraMinuto.format((Date) value);
                }
                return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }

        });

    }

    private void mostrarDatos() {
        RptMarcacion marcacion = this.marcacionList.get(0);
        this.lblEmpleado.setText(String.format("EMPLEADO: %s", marcacion.getEmpleado().getNombreCompleto()));
        this.lblFecha.setText(String.format("FECHA: %s", HerramientaGeneral.formatoFecha.format(marcacion.getFecha())));
        
    }
}
