/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.marcos.dto.Cliente;
import org.marcos.dto.DetalleComplementos;
import org.marcos.dto.DetalleOrden;
import org.marcos.dto.Orden;
import org.proyectoa2.ventas.controller.ManejoColaOrdenes;
import org.proyectoa2.ventas.controller.ManejoListaClientes;
import org.proyectoa2.ventas.controller.ManejoOrden;

/**
 *
 * @author marcos
 */
public class NuevaOrdenForm extends javax.swing.JFrame {
    private AgregarPlatilloForm agregarPlatillo;
    private AgregarClienteForm agregarCliente;
    private ManejoListaClientes manejador;
    private ManejoOrden manejadorOrden;
    
    /**
     * Creates new form NuevaOrdenForm
     */
    public NuevaOrdenForm() {
        initComponents();
    }
    public NuevaOrdenForm(String titulo) {
        initComponents();
        this.etiquetaTitulo.setText(titulo);
        manejador = ManejoListaClientes.obtenerManejador();
        this.ActualizarListaClientes();
        
        manejadorOrden = new ManejoOrden();
        
            
    }
    public NuevaOrdenForm(String titulo, Orden orden) {
        initComponents();
        this.etiquetaTitulo.setText(titulo);
        manejador = ManejoListaClientes.obtenerManejador();
        this.ActualizarListaClientes();
        int indice = manejador.geListaClientes().indexOf(orden.getCliente());
        Object tmp = listaSeleccionCliente.getItemAt(indice);
        this.listaSeleccionCliente.setSelectedItem(tmp);
        manejadorOrden = new ManejoOrden(orden);
        this.ActualizarListaPlatillos();
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaPlatillos = new javax.swing.JList<>();
        etiquetaSeleccionarCliente = new javax.swing.JLabel();
        botonAgregarPlatillo = new javax.swing.JButton();
        botonConfirmarOrden = new javax.swing.JButton();
        botonCancelarOrden = new javax.swing.JButton();
        listaSeleccionCliente = new javax.swing.JComboBox<>();
        etiquetaTotal = new javax.swing.JLabel();
        etiquetaTotalOrden = new javax.swing.JLabel();
        botonEliminarPlatillo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        etiquetaTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        botonAgregarCliente = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaPlatillos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaPlatillos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 340, 570));

        etiquetaSeleccionarCliente.setText("Seleccionar Cliente");
        getContentPane().add(etiquetaSeleccionarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        botonAgregarPlatillo.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        botonAgregarPlatillo.setText("Agregar Platillo");
        botonAgregarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarPlatilloActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregarPlatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 480, 40));

        botonConfirmarOrden.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        botonConfirmarOrden.setText("Confirmar Orden");
        botonConfirmarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarOrdenActionPerformed(evt);
            }
        });
        getContentPane().add(botonConfirmarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 480, 40));

        botonCancelarOrden.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        botonCancelarOrden.setText("Cancelar");
        botonCancelarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarOrdenActionPerformed(evt);
            }
        });
        getContentPane().add(botonCancelarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 583, 480, 40));

        listaSeleccionCliente.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        listaSeleccionCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"---- Seleccione al Cliente ----"}));
        getContentPane().add(listaSeleccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 560, 30));

        etiquetaTotal.setText("Total");
        getContentPane().add(etiquetaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        etiquetaTotalOrden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(etiquetaTotalOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 510, 40));

        botonEliminarPlatillo.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        botonEliminarPlatillo.setText("Eliminar Platillo");
        botonEliminarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPlatilloActionPerformed(evt);
            }
        });
        getContentPane().add(botonEliminarPlatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 480, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 610, 10));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 620, 10));

        etiquetaTitulo.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        etiquetaTitulo.setText("Nueva Orden");
        getContentPane().add(etiquetaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Platillos de la orden");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));

        botonAgregarCliente.setText("Agregar Cliente");
        botonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 183, 540, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarPlatilloActionPerformed
        // TODO add your handling code here:
        this.agregarPlatillo = new AgregarPlatilloForm(this , manejadorOrden);
        this.agregarPlatillo.setVisible(true);
    }//GEN-LAST:event_botonAgregarPlatilloActionPerformed

    private void botonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarClienteActionPerformed
        // TODO add your handling code here:
        agregarCliente = new AgregarClienteForm(this);
        agregarCliente.setVisible(true);
    }//GEN-LAST:event_botonAgregarClienteActionPerformed

    private void botonConfirmarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarOrdenActionPerformed
        // TODO add your handling code here:
        if(this.listaSeleccionCliente.getSelectedIndex() <= 0 ||
                manejadorOrden.getOrden().getDetalles().isEmpty()){
            String tmp = "Error, no se la seleccionado un platillo de la lista";
            if(this.listaSeleccionCliente.getSelectedIndex() <= 0 ){
                tmp += "\n   * Seleccione un cliente valido";
            }
            if(manejadorOrden.getOrden().getDetalles().isEmpty() ){
                tmp += "\n   * No hay ningun platillo agregado";
            }
            JOptionPane.showMessageDialog(null, tmp, "Error, no se puede procesar!!!", JOptionPane.WARNING_MESSAGE);
        }else{
            this.manejadorOrden.prepararOrden(manejador.getCliente(this.listaSeleccionCliente.getSelectedIndex() - 1), this.etiquetaTotalOrden.getText());
            if(this.etiquetaTitulo.getText().equals("Nueva Orden")){
                this.manejadorOrden.confirmarOrden();
            }else{
                this.manejadorOrden.confirmarModificacionOrden();
                
            }
            JOptionPane.showMessageDialog(null, "Notificacion", "Operacion realizada con exito!!!", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
    }//GEN-LAST:event_botonConfirmarOrdenActionPerformed

    private void botonCancelarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarOrdenActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarOrdenActionPerformed

    private void botonEliminarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPlatilloActionPerformed
        // TODO add your handling code here:
        if(this.listaPlatillos.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(null, "Error, no se la seleccionado un platillo de la lista", "Error, no se puede procesar!!!", JOptionPane.WARNING_MESSAGE);
        }else{
            this.manejadorOrden.eliminarPlatillo(this.listaPlatillos.getSelectedIndex());
        }
    }//GEN-LAST:event_botonEliminarPlatilloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevaOrdenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaOrdenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaOrdenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaOrdenForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaOrdenForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarCliente;
    private javax.swing.JButton botonAgregarPlatillo;
    private javax.swing.JButton botonCancelarOrden;
    private javax.swing.JButton botonConfirmarOrden;
    private javax.swing.JButton botonEliminarPlatillo;
    private javax.swing.JLabel etiquetaSeleccionarCliente;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel etiquetaTotal;
    private javax.swing.JLabel etiquetaTotalOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JList<String> listaPlatillos;
    private javax.swing.JComboBox<String> listaSeleccionCliente;
    // End of variables declaration//GEN-END:variables

    public void ActualizarListaClientes(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel<>(new String[] {"---- Seleccione al Cliente ----"});
        manejador.actualizarClientes();
        listaSeleccionCliente.setModel(modelo);
        ArrayList<Cliente> lista = manejador.geListaClientes();
        String tmp;
        for(Cliente item : lista){
            tmp = item.getNombreCliente() + " | Saldo: " + item.getSaldo();
            listaSeleccionCliente.addItem(tmp);
        }
    }
    public void ActualizarListaPlatillos(){
        String tmp;
        double total = 0;
        double precio;
        DefaultListModel modelo = new DefaultListModel();
        for(DetalleOrden item : manejadorOrden.getOrden().getDetalles()){
            precio = manejadorOrden.getTotalDetalle(item);
            tmp = item.getMenu().getNombreMenu()+  " || Cantidad: " + item.getCantidad() + " || subtotal: " + precio;
            modelo.addElement(tmp);
            total += precio;
        }
        this.etiquetaTotalOrden.setText(Double.toString(total));
        this.listaPlatillos.setModel(modelo);
    }
}
