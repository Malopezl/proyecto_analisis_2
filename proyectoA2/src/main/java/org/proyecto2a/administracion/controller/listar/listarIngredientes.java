/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.controller.listar;


import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.marcos.sql.InventarioSql;

/**
 *
 * @author sharon
 */
public class listarIngredientes {
    public static DefaultListModel listarInventario() {
    DefaultListModel modelo = new DefaultListModel();
    ArrayList<String> listaNombre = InventarioSql.selectNombre();
    
    for(String nombre : listaNombre){
        modelo.addElement(nombre);
    }
    return modelo;
    
    }
}
