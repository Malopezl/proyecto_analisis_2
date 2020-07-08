/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.controller.listar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import static org.marcos.sql.InventarioSql.LGENERAL;

/**
 *
 * @author sharon
 */
public class listarIngredientes {

    public static DefaultListModel listarInventario() {
    DefaultListModel modelo = new DefaultListModel();
    ResultSet rs = LGENERAL();
    //rs obtiene el listado de nombres desde la bd
        try {
            while (rs.next()) {
            modelo.addElement(rs.getNString("nombre"));
            // agrega a una defaultListModel todos los nombres de inventario.
        }
    }
    catch (SQLException ex) {
        Logger.getLogger(listarIngredientes.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return modelo;
    
    }
}
