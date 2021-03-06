/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.compras.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Compra;
import org.marcos.dto.DetalleCompra;
import org.marcos.dto.Inventario;
import org.marcos.dto.Proveedor;
import org.proyectoa2.compras.controlador.ManejoCompra;
import org.proyectoa2.compras.controlador.ManejoListaInsumos;
import org.proyectoa2.proveedores.controlador.ManejoListaProveedores;
import org.proyectoa2.inventario.vista.AgregarInventario;
import org.proyectoa2.proveedores.vista.AgregarProveedor;

/**
 *
 * @author malopez
 */
public final class NuevaCompra extends javax.swing.JFrame {
    private AgregarInventario inventario;
    private final ManejoListaProveedores manejadorProveedor;
    private final ManejoListaInsumos manejadorInsumos;
    private ManejoCompra manejadorCompra;
    private final Compra compra;
    private DetalleCompra detalle;
    private AgregarProveedor agregarProveedor;
    
    /**
     * Creates new form NuevaCompra
     */
    public NuevaCompra() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.botonBorrarInsumo.setEnabled(false);
        this.botonAgregarInsumo.setEnabled(false);
        this.botonEditarCantidad.setEnabled(false);
        this.botonEnviarPedido.setEnabled(false);
        manejadorProveedor = ManejoListaProveedores.obtenerProveedores();
        manejadorInsumos = ManejoListaInsumos.obtenerInsumos();
        this.ActualizarListaProveedores();
        this.ActualizarListaInsumos();
        this.compra = new Compra();
        this.detalle = new DetalleCompra();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTotal = new javax.swing.JLabel();
        campoFactura = new javax.swing.JTextField();
        listaProveedores = new javax.swing.JComboBox<>();
        seleccionadorFecha = new com.toedter.calendar.JDateChooser();
        botonCrearProveedor = new javax.swing.JButton();
        listaInsumos = new javax.swing.JComboBox<>();
        campoCantidad = new javax.swing.JTextField();
        botonCrearInsumo = new javax.swing.JButton();
        botonAgregarInsumo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInsumosCompra = new javax.swing.JTable();
        botonEditarCantidad = new javax.swing.JButton();
        botonBorrarInsumo = new javax.swing.JButton();
        botonEnviarPedido = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(760, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Nueva Compra");
        jLabel1.setFocusable(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        jLabel8.setText("No. Factura");
        jLabel8.setFocusable(false);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione Proveedor");
        jLabel2.setFocusable(false);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel3.setText("Fecha");
        jLabel3.setFocusable(false);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel4.setText("Seleccione Insumo");
        jLabel4.setFocusable(false);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        jLabel5.setText("Cantidad");
        jLabel5.setFocusable(false);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Total:");
        jLabel6.setFocusable(false);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, -1, -1));

        campoTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        campoTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        campoTotal.setFocusable(false);
        getContentPane().add(campoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 180, 30));
        getContentPane().add(campoFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 160, 30));

        listaProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(listaProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 210, 30));

        seleccionadorFecha.setDateFormatString("dd MMM, yyyy");
        getContentPane().add(seleccionadorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 160, -1));

        botonCrearProveedor.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        botonCrearProveedor.setText("Nuevo Proveedor");
        botonCrearProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(botonCrearProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, 50));

        listaInsumos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(listaInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 30));

        campoCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCantidadKeyTyped(evt);
            }
        });
        getContentPane().add(campoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 110, 30));

        botonCrearInsumo.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        botonCrearInsumo.setText("Nuevo Insumo");
        botonCrearInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearInsumoActionPerformed(evt);
            }
        });
        getContentPane().add(botonCrearInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, 50));

        botonAgregarInsumo.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        botonAgregarInsumo.setText("Agregar Insumo");
        botonAgregarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarInsumoActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregarInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 180, 50));

        tablaInsumosCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Insumo", "Cantidad", "Precio", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaInsumosCompra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 480, 210));

        botonEditarCantidad.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        botonEditarCantidad.setText("Editar Cantidad");
        botonEditarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(botonEditarCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, -1, 50));

        botonBorrarInsumo.setFont(new java.awt.Font("DialogInput", 0, 16)); // NOI18N
        botonBorrarInsumo.setText("Borrar Insumo");
        botonBorrarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarInsumoActionPerformed(evt);
            }
        });
        getContentPane().add(botonBorrarInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, -1, 50));

        botonEnviarPedido.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        botonEnviarPedido.setText("Enviar Pedido");
        botonEnviarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(botonEnviarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 530, -1, 40));

        botonSalir.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        botonSalir.setText("Cancelar");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, -1, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearInsumoActionPerformed
        inventario = new AgregarInventario();
        inventario.setVisible(true);
    }//GEN-LAST:event_botonCrearInsumoActionPerformed

    private void botonAgregarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarInsumoActionPerformed
        if (this.listaInsumos.getSelectedIndex() <= 0) {
            String tmp = "No se ha seleccionado un Insumo de la lista";
            JOptionPane.showMessageDialog(null, tmp, "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            double total;
            if (campoTotal.getText().equals(""))
                total = 0;
            else
                total = Double.parseDouble(campoTotal.getText());
            
            Inventario tmp;
            DefaultTableModel modelo = (DefaultTableModel) this.tablaInsumosCompra.getModel();
            tmp = manejadorInsumos.getInsumo(this.listaInsumos.getSelectedIndex() - 1);
            double precio = Math.random()*50 + 1;
            double subtotal = Integer.parseInt(campoCantidad.getText()) * precio;
            modelo.addRow(new Object[]{tmp.getNombre(), campoCantidad.getText(), precio, subtotal});
            total = total + subtotal;
            campoTotal.setText(String.valueOf(total));
            
            if (this.botonEditarCantidad.isEnabled() == false && this.botonEnviarPedido.isEnabled() == false) {
                this.botonEditarCantidad.setEnabled(true);
                this.botonBorrarInsumo.setEnabled(true);
                this.botonEnviarPedido.setEnabled(true);
            }
        }
    }//GEN-LAST:event_botonAgregarInsumoActionPerformed

    private void botonBorrarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarInsumoActionPerformed
        if (tablaInsumosCompra.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "No hay insumos agregados", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (tablaInsumosCompra.getSelectedRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un insumo", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Esta seguro de que quiere borrar el insumo", "Confirmar Borrar Insumo", JOptionPane.OK_CANCEL_OPTION) == 0) {
                double total = Double.parseDouble(campoTotal.getText());
                double subtotal;
                DefaultTableModel modelo = (DefaultTableModel) this.tablaInsumosCompra.getModel();
                
                subtotal = (double) tablaInsumosCompra.getValueAt(tablaInsumosCompra.getSelectedRow(), 3);
                modelo.removeRow(tablaInsumosCompra.getSelectedRow());
                tablaInsumosCompra.setModel(modelo);
                total = total - subtotal;
                campoTotal.setText(String.valueOf(total));
            }
        }
    }//GEN-LAST:event_botonBorrarInsumoActionPerformed

    private void botonEnviarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarPedidoActionPerformed
        if (this.listaProveedores.getSelectedIndex() <= 0 || this.tablaInsumosCompra.getRowCount() < 1) {
            String tmp = "No se puede procesar la compra";
            if (this.listaProveedores.getSelectedIndex() <= 0)
                tmp = tmp + "\nNo ha seleccionado ningun proveedor";
            else
                tmp = tmp + "\nNo ha agregado ningun insumo a la compra";
            JOptionPane.showMessageDialog(null, tmp, "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Esta seguro que desea enviar", "Confirmar Compra", JOptionPane.OK_CANCEL_OPTION) == 0) {
                manejadorCompra = new ManejoCompra(compra);
                double total = Double.valueOf(campoTotal.getText());
                compra.setNoFactura(campoFactura.getText());
                compra.setIdProveedor(manejadorProveedor.getProveedor(listaProveedores.getSelectedIndex() - 1).getIdProveedor());
                compra.setProveedor(manejadorProveedor.getProveedor(listaProveedores.getSelectedIndex() - 1));
                compra.setFecha(seleccionadorFecha.getDate());

                for (int i = 0; i < tablaInsumosCompra.getRowCount(); i++) {
                    String nombre = (String) tablaInsumosCompra.getValueAt(i, 0);
                    String c = (String) tablaInsumosCompra.getValueAt(i, 1);
                    float cantidad = Float.valueOf(c);
                    double precio = (double) tablaInsumosCompra.getValueAt(i, 2);
                    double subtotal = (double) tablaInsumosCompra.getValueAt(i, 3);
                    detalle = new DetalleCompra(compra.getIdCompra(), manejadorInsumos.getInsumo(nombre).getIdInventario(), cantidad, subtotal, precio);
                    manejadorCompra.agregarDetalle(detalle);
                }
                
                compra.setTotal(total);
                manejadorCompra.registrarCompra(compra);
                manejadorProveedor.agregarSaldo(manejadorProveedor.getProveedor(listaProveedores.getSelectedIndex() - 1), total);
                JOptionPane.showMessageDialog(null, "Se ha enviado el pedido exitosamente.", "Envio aceptado", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
            }
        }
    }//GEN-LAST:event_botonEnviarPedidoActionPerformed

    private void campoCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCantidadKeyTyped
        if (botonAgregarInsumo.isEnabled() == false) {
            this.botonAgregarInsumo.setEnabled(true);
        }
    }//GEN-LAST:event_campoCantidadKeyTyped

    private void botonEditarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarCantidadActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Los datos que ingreso son correctos?", "Confirmar editar cantidad", JOptionPane.YES_NO_OPTION) == 0) {
            double total = 0, precio, subtotal;
            float cantidad;
            
            for (int i = 0; i < tablaInsumosCompra.getRowCount(); i++) {
                String c = (String) tablaInsumosCompra.getValueAt(i, 1);
                cantidad = Float.valueOf(c);
                precio = (double) tablaInsumosCompra.getValueAt(i, 2);
                subtotal = (double) cantidad * precio;
                tablaInsumosCompra.setValueAt((Object) subtotal, i, 3);
                total = total + subtotal;
            }
            campoTotal.setText(String.valueOf(total));
        }
    }//GEN-LAST:event_botonEditarCantidadActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonCrearProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearProveedorActionPerformed
        agregarProveedor = new AgregarProveedor();
        agregarProveedor.setVisible(true);
    }//GEN-LAST:event_botonCrearProveedorActionPerformed

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
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NuevaCompra().setVisible(true);
            }
        });
    }
    
    public void ActualizarListaProveedores(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel<>(new String[] {"- Seleccione al Proveedor -"});
        manejadorProveedor.actualizarProveedores();
        listaProveedores.setModel(modelo);
        ArrayList<Proveedor> lista = manejadorProveedor.getListaProveedores();
        String tmp;
        for (Proveedor item : lista) {
            tmp = item.getNombreProveedor();
            listaProveedores.addItem(tmp);
        }
    }
    
    public void ActualizarListaInsumos(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel<>(new String[] {"--- Seleccione el Insumo ---"});
        manejadorInsumos.actualizarInsumos();
        listaInsumos.setModel(modelo);
        ArrayList<Inventario> lista = manejadorInsumos.getListaInsumos();
        String tmp;
        for (Inventario item : lista) {
            tmp = item.getNombre();
            listaInsumos.addItem(tmp);
        }
    }
    
    public void limpiar() {
        ActualizarListaProveedores();
        ActualizarListaInsumos();
        this.campoFactura.setText("");
        this.campoCantidad.setText("");
        this.campoTotal.setText("");
        DefaultTableModel modelo = (DefaultTableModel) tablaInsumosCompra.getModel();
        modelo.setRowCount(0);
        tablaInsumosCompra.setModel(modelo);
        this.botonAgregarInsumo.setEnabled(false);
        this.botonBorrarInsumo.setEnabled(false);
        this.botonEditarCantidad.setEnabled(false);
        this.botonEnviarPedido.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarInsumo;
    private javax.swing.JButton botonBorrarInsumo;
    private javax.swing.JButton botonCrearInsumo;
    private javax.swing.JButton botonCrearProveedor;
    private javax.swing.JButton botonEditarCantidad;
    private javax.swing.JButton botonEnviarPedido;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoFactura;
    private javax.swing.JLabel campoTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listaInsumos;
    private javax.swing.JComboBox<String> listaProveedores;
    private com.toedter.calendar.JDateChooser seleccionadorFecha;
    private javax.swing.JTable tablaInsumosCompra;
    // End of variables declaration//GEN-END:variables
}
