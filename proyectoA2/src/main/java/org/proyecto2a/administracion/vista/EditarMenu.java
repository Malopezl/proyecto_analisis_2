/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.vista;

import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.marcos.dto.IngredienteMenu;
import org.marcos.dto.Inventario;
import org.marcos.dto.Menu;
import org.marcos.sql.IngredienteMenuSql;
import org.proyecto2a.administracion.controller.ControladorMenu;
import org.proyecto2a.administracion.controller.listar.listarIngredientes;

/**
 *
 * @author sharon
 */
public class EditarMenu extends javax.swing.JFrame {

    /**
     * Creates new form CrearMenu
     */
    private ArrayList<String> listaNombres;
    private ArrayList<Double> listaCantidad;
    private ArrayList<String> listaDimensiones;
    private ArrayList<IngredienteMenu> ingredientesAgregados;
    private ArrayList<Inventario>listaInventario;
    private Menu menu;
    
    public EditarMenu() {
        initComponents();
        this.inicializar();
    }
    public EditarMenu(Menu menu) throws SQLException {
        initComponents();
        this.inicializar();
        this.SetMenu(menu);
        SetDatos();
    }
     private void inicializar(){
        this.setSize(new Dimension(1000, 700));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.ingredientesAgregados = new ArrayList<>();
        this.listaNombres = new ArrayList<>();
        this.listaCantidad = new ArrayList<>();
        this.listaDimensiones = new ArrayList<>();
    }
     private void SetMenu(Menu menu){
         this.menu = menu;
     }
     private void SetDatos() throws SQLException{
         this.jTextFieldNombre.setText(menu.getNombreMenu());
         this.jTextAreaDescripcion.setText(menu.getDescripcionMenu());
         this.jTextFieldPrecio.setText(String.valueOf(menu.getPrecio()));
         this.jTextAreaReceta.setText(menu.getReceta());
         this.inicioListaIngredientes();
         this.recuperarIngredientes(menu.getIdMenu());
         this.actualizarLista();
         
     }
     private void inicioListaIngredientes() throws SQLException{
       DefaultListModel modelo = new DefaultListModel();
       this.listaInventario=listarIngredientes.listarInventario();
       for(Inventario i : listaInventario){
            modelo.addElement(i.getNombre());
        }  
        this.listaIngredientes.setModel(modelo);
     }
     private void recuperarIngredientes(int idMenu){
         ArrayList<IngredienteMenu> listaIngredientesRecu = IngredienteMenuSql.LINGREDIENTES(idMenu);
         for(IngredienteMenu ingrediente: listaIngredientesRecu){
           Inventario inventario = this.buscarInventario(ingrediente.getIdInventario());
           this.listaNombres.add(inventario.getNombre());
           this.listaCantidad.add(ingrediente.getCantidad());
           this.listaDimensiones.add(inventario.getDimension());
         }
         
     }
     private void actualizarLista(){
         DefaultListModel seleccionados = new DefaultListModel();
         if(this.listaNombres.isEmpty())
         {
             this.listaIngredientesSeleccionados.setModel(seleccionados);
         }else{
         for(int i=0; i<this.listaNombres.size(); i++){
             seleccionados.addElement( this.listaNombres.get(i) + "- Cantidad: "+ this.listaCantidad.get(i) + " " + this.listaDimensiones.get(i));
         }
         this.listaIngredientesSeleccionados.setModel(seleccionados);
         }
     } 
      private boolean validarDouble(String ContenedorDouble){
         try{
             Double.parseDouble(ContenedorDouble);
             return true;
         } catch(NumberFormatException e){
             return false;
         }
     }
      private boolean validarForm(){
         if (this.jTextFieldNombre.getText().isBlank()) {
             JOptionPane.showMessageDialog(this, "Ingrese el nombre del menú", "Nombre de menú incorrecto", JOptionPane.ERROR_MESSAGE);
             return false;
         } else if (this.jTextAreaDescripcion.getText().isBlank()) {
             JOptionPane.showMessageDialog(this, "Ingrese una descripción al menú", "Descripción de menú incorrecta", JOptionPane.ERROR_MESSAGE);
             return false;
         } else if (this.jTextFieldPrecio.getText().isBlank()) {
             JOptionPane.showMessageDialog(this, "Ingrese el precio del menú", "Precio de menú incorrecto", JOptionPane.ERROR_MESSAGE);
             return false;
         }else if(!this.validarDouble(this.jTextFieldPrecio.getText())){
              JOptionPane.showMessageDialog(this, "El precio del menú no es válido", "Precio de menú incorrecto", JOptionPane.ERROR_MESSAGE);
             return false; 
         }
         else if(this.jTextAreaReceta.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Ingrese la receta del menú", "Receta de menú incorrecta", JOptionPane.ERROR_MESSAGE);
            return false; 
         }
         else if(this.listaNombres.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese ingredientes a utilizar en el menú.", "Listado de ingredientes incorrecto", JOptionPane.ERROR_MESSAGE);
            return false;
         }
     else{ 
         return true;
          }
     }
      
     private boolean validarAgregarIngredientes() {
        if (this.listaIngredientes.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un ingrediente para agregar al menú.", "Ingrediente seleccionado incorrecto", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (this.jTextFieldCantidad.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad del ingrediente a utilizar", "Cantidad de ingrediente incorrecto", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!this.validarDouble(this.jTextFieldCantidad.getText())) {
            JOptionPane.showMessageDialog(this, "La cantidad de ingrediente no es válida", "Cantidad de ingrediente incorrecta8", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }

     }
     private String buscarDimensiones(String nombreInventario)
     {
         String dimension="";
         for(Inventario i : listaInventario)
         {
             if(i.getNombre().equals(nombreInventario))
                 dimension=i.getDimension();
         }
         return dimension;
     }
     private Inventario buscarInventario(int idInventario)
     {
         Inventario inventario=new Inventario();
         for(Inventario i : listaInventario)
         {
             if(i.getIdInventario() == idInventario)
                 inventario = i;
         }
         return inventario;
         
     }
     private int buscarIdInventario(String nombreInventario)
     {
         int idInventario=-1;
         for(Inventario i : listaInventario)
         {
             if(i.getNombre().equals(nombreInventario))
                 idInventario=i.getIdInventario();
         }
         return idInventario;
         
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonRegresar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaReceta = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaIngredientes = new javax.swing.JList<>();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        botonAgregarIngredientes = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaIngredientesSeleccionados = new javax.swing.JList<>();
        botonEliminarIngredientes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("FreeSerif", 1, 24)); // NOI18N
        jLabel1.setText("EDITAR MENÚ");

        jLabel2.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel2.setText("Ingrese el nombre del menú:");

        jLabel3.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel3.setText("Ingrese la descripción del menú:");

        jLabel4.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel4.setText("Ingrese el precio de venta del menú:");

        jLabel5.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel5.setText("Ingrese la receta de preparación del menú:");

        botonRegresar.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        botonRegresar.setText("Cancelar");
        botonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegresarActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        jTextFieldNombre.setFont(new java.awt.Font("FreeSerif", 0, 18)); // NOI18N
        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });

        jTextFieldPrecio.setFont(new java.awt.Font("FreeSerif", 0, 18)); // NOI18N

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcion);

        jTextAreaReceta.setColumns(20);
        jTextAreaReceta.setRows(5);
        jScrollPane2.setViewportView(jTextAreaReceta);

        jLabel6.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel6.setText("Seleccione los ingredientes:");

        listaIngredientes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(listaIngredientes);

        jTextFieldCantidad.setFont(new java.awt.Font("FreeSerif", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel7.setText("Cantidad a utilizar:");

        botonAgregarIngredientes.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        botonAgregarIngredientes.setText("Agregar ingrediente al menú");
        botonAgregarIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarIngredientesActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jLabel8.setText("Lista de ingrediente añadidos:");

        listaIngredientesSeleccionados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listaIngredientesSeleccionados);

        botonEliminarIngredientes.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        botonEliminarIngredientes.setText("Eliminar ingrediente del menú");
        botonEliminarIngredientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarIngredientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 894, Short.MAX_VALUE)
                        .addComponent(botonGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jLabel5)
                                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldNombre)
                                    .addComponent(jScrollPane1))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonAgregarIngredientes, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonEliminarIngredientes, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonRegresar, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(botonAgregarIngredientes)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEliminarIngredientes)
                        .addGap(37, 37, 37)
                        .addComponent(botonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonRegresar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextFieldNombreActionPerformed

    private void botonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_botonRegresarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if (this.validarForm()) {
            try {
                for(int i=0; i<listaNombres.size(); i++)
                {
                    IngredienteMenu im = new IngredienteMenu();
                    im.setCantidad(listaCantidad.get(i));
                    int idInventarioTemp =this.buscarIdInventario(listaNombres.get(i));
                    if(idInventarioTemp != (-1));
                    im.setIdInventario(idInventarioTemp);
                    this.ingredientesAgregados.add(im);
                }
                boolean ingresoCorrecto= ControladorMenu.EditarMenu(this.menu.getIdMenu(),
                        this.jTextFieldNombre.getText().trim(),
                        this.jTextAreaDescripcion.getText().trim(),
                        Double.parseDouble(this.jTextFieldPrecio.getText().trim()),
                        this.jTextAreaReceta.getText().trim(),
                        this.menu.getEstado(),
                        this.ingredientesAgregados
                );
                if(ingresoCorrecto==true){
                  JOptionPane.showMessageDialog(this, "El menú ha sido actualizado exitosamente.", "Menu actualizado exitosamente.", JOptionPane.PLAIN_MESSAGE);
                  this.dispose();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(CrearMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            
        }
        
        
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonAgregarIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarIngredientesActionPerformed
        // TODO add your handling code here:
        if (this.validarAgregarIngredientes()) {
            this.listaNombres.add(this.listaIngredientes.getSelectedValue());
            this.listaCantidad.add(Double.parseDouble(this.jTextFieldCantidad.getText().trim()));
            this.listaDimensiones.add(this.buscarDimensiones(this.listaIngredientes.getSelectedValue()));
            this.actualizarLista();

            if (!this.listaNombres.isEmpty()) {
                this.botonEliminarIngredientes.setEnabled(true);
            }
        }
    }//GEN-LAST:event_botonAgregarIngredientesActionPerformed

    private void botonEliminarIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarIngredientesActionPerformed
        // TODO add your handling code here:
        if (this.listaIngredientesSeleccionados.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un ingrediente para eliminar del menú.", "Ingrediente seleccionado incorrecto", JOptionPane.ERROR_MESSAGE);
        } else {
            int indice = this.listaIngredientesSeleccionados.getSelectedIndex();
            this.listaNombres.remove(indice);
            this.listaCantidad.remove(indice);
            this.listaDimensiones.remove(indice);
            this.actualizarLista();

            if (this.listaNombres.isEmpty()) {
                this.botonEliminarIngredientes.setEnabled(false);
            }
        }
    }//GEN-LAST:event_botonEliminarIngredientesActionPerformed

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
            java.util.logging.Logger.getLogger(EditarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarIngredientes;
    private javax.swing.JButton botonEliminarIngredientes;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextArea jTextAreaReceta;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JList<String> listaIngredientes;
    private javax.swing.JList<String> listaIngredientesSeleccionados;
    // End of variables declaration//GEN-END:variables
}
