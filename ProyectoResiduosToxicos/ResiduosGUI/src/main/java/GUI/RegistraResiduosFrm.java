/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import com.daos.IQuimicoDAO;
import com.daos.QuimicoDAOImp;
import com.dto.DTORegistraResiduo;
import com.validaciones.QuimicoNegocio;
import com.validaciones.ResiduoNegocio;
import entitys.ProductorModel;
import entitys.QuimicoModel;
import entitys.UsuarioModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author xfs85
 */
public class RegistraResiduosFrm extends javax.swing.JFrame {

    /**
     * Creates new form RegistraResiduosFrm
     */
    DefaultListModel<String> modelDisponibles = new DefaultListModel<>();
    DefaultListModel<String> modelSeleccionados = new DefaultListModel<>();
    QuimicoNegocio qn = new QuimicoNegocio();
    IQuimicoDAO qdao = new QuimicoDAOImp();
    UsuarioModel usuarioActual = new ProductorModel();
    ResiduoNegocio residuoNeg = new ResiduoNegocio(); 
    public RegistraResiduosFrm(UsuarioModel usuario) {
        initComponents();
        this.usuarioActual = usuario;
        quimicosDisponiblesList.setModel(modelDisponibles);
        quimicosReservadosList.setModel(modelSeleccionados);
        
        inicializaLista();
        this.setTitle("Registrar Residuos");
    }

    public void inicializaLista() {
        
        List<QuimicoModel> listaQuimicos = qn.llenaListaQuimicos();
        
        for(QuimicoModel quimico: listaQuimicos){
            modelDisponibles.addElement(quimico.getNombre());
        }
    }
    



    public boolean verificaFormatoCodigo() {
        String codigo = txtCodigo.getText();

        if (codigo.matches("\\d{6}")) {
            return true;
        }

        mostrarError("Ingrese un código válido", "Error", "Error al Registrar");
        return false;
    }

    public boolean verificaFormatosVacios() {
        if (txtNombre.getText().isBlank()) {
            mostrarError("Nombre vacío, ingrese uno", "Error", "Error al registrar");
            return false;
        }
        return true;
    }

   public boolean verificaSeleccionados() {
    int cantidadSeleccionada = modelSeleccionados.size(); 

    if (cantidadSeleccionada < 2) {
        mostrarError("Debe seleccionar al menos 2 químicos", "Error", "Error al registrar");
        return false;
    }

    return true;
}
       public List<QuimicoModel> obtenerListaDeQuimicos(){
           List<QuimicoModel> quimicosSeleccionados = new ArrayList<>();
           for(int i = 0; i < modelSeleccionados.size(); i++){
               String quimicoActual = modelSeleccionados.getElementAt(i);
               QuimicoModel quimico = qn.buscarQuimicoPorNombre(quimicoActual);
               quimicosSeleccionados.add(quimico);
           }
           return quimicosSeleccionados;
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        agregarBtn = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        quimicosReservadosList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        quimicosDisponiblesList = new javax.swing.JList<>();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setContentAreaFilled(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 40, 30));

        agregarBtn.setContentAreaFilled(false);
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(agregarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 152, 90, 30));

        eliminarBtn.setContentAreaFilled(false);
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });
        jPanel1.add(eliminarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 332, 90, 30));

        jScrollPane5.setBorder(null);

        quimicosReservadosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(quimicosReservadosList);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 170, 130));

        jScrollPane2.setBorder(null);

        quimicosDisponiblesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(quimicosDisponiblesList);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 170, 130));

        txtCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 340, 50));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 340, 50));

        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantalla Registrar Residuo - Residuos Tóxicos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 720, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        // TODO add your handling code here:
        if (quimicosDisponiblesList.getSelectedIndex() != -1) {
            agregaAListaSeleccionados();
            eliminaDeListaDisponibles();
        } else if (quimicosReservadosList.getSelectedIndex() != -1) {
            mostrarError("No puedes agregar ningun quimico aquí", "Error", "Error al Agregar");
        } else {
            mostrarError("No seleccionó ningun quimico", "Error", "Error al Agregar");
        }
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
        // TODO add your handling code here:
        if (quimicosReservadosList.getSelectedIndex() != -1) {
            agregaAListaDisponibles();
            eliminaDeListaSeleccionados();
        } else if (quimicosDisponiblesList.getSelectedIndex() != -1) {
            mostrarError("No puedes eliminar un quimico de aquí", "Error", "Error al Eliminar");
        } else {
            mostrarError("No seleccionó ningun quimico", "Error", "Error al Eliminar");
        }
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (verificaFormatoCodigo() == true) {

            if (verificaFormatosVacios() == true) {

                if (verificaSeleccionados() == true) {
                    DTORegistraResiduo dtoRegistrarResiduo = new DTORegistraResiduo(); 
                    dtoRegistrarResiduo.setNombre_residuo(this.txtNombre.getText());
                    dtoRegistrarResiduo.setQuimicos(obtenerListaDeQuimicos());
                    dtoRegistrarResiduo.setCodigo_residuo(Long.parseLong(this.txtCodigo.getText()));
                    dtoRegistrarResiduo.setId_productor(null);
                    residuoNeg.guardar(dtoRegistrarResiduo); 
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    
                    UsuarioModel usuario = new UsuarioModel();
                    usuario.setTipo("Productor");
                    new PantallaInicial(usuario).setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        UsuarioModel usuario = new UsuarioModel();
        usuario.setTipo("Productor");
        new PantallaInicial(usuario).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    public void eliminaDeListaDisponibles() {
        modelDisponibles.removeElementAt(quimicosDisponiblesList.getSelectedIndex());
    }

    public void agregaAListaDisponibles() {
        modelDisponibles.addElement(quimicosReservadosList.getSelectedValue());
    }

    public void eliminaDeListaSeleccionados() {
        modelSeleccionados.removeElementAt(quimicosReservadosList.getSelectedIndex());
    }

    public void agregaAListaSeleccionados() {
        modelSeleccionados.addElement(quimicosDisponiblesList.getSelectedValue());
    }

    public void mostrarError(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton eliminarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> quimicosDisponiblesList;
    private javax.swing.JList<String> quimicosReservadosList;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables



}
