/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.marcos.dto.IngredienteMenu;
import org.marcos.dto.Menu;
import org.marcos.sql.InventarioSql;
import org.marcos.sql.MenuSql;

/**
 *
 * @author sharon
 */
public class ControladorMenu {
    
    
    
    public static void AgregarMenu(String nombre, String descripcion, double precio, String receta, ArrayList<String>ingrediente, ArrayList<Double> cantidad) throws SQLException{
      Menu menuNuevo = new Menu(nombre, descripcion, precio, receta, "CREADO");
      int idMenu = MenuSql.Insertar(menuNuevo);
      ControladorMenu.AgregarIngredientes(idMenu, ingrediente, cantidad);    
    }
    private static void AgregarIngredientes(int idMenu, ArrayList<String>nombre, ArrayList<Double>cantidad) throws SQLException{
        if (!(nombre.isEmpty() || cantidad.isEmpty())) {
            for (int i = 0; i < nombre.size(); i++) {
                IngredienteMenu ingrediente = new IngredienteMenu();
                ingrediente.setIdInventario(getIDProducto(nombre.get(i)));
                ingrediente.setCantidad(cantidad.get(i));
                ingrediente.setIdMenu(idMenu);
                // llamar a IngredienteMenu Sql
                // agregar las dimensiones del ingrediente
                
            }
        }
    }
    public static void EditarMenu(){
        
    }
    public static void VerMenu(){
        
    }
    public void notificar(){
        
    }
    private static int getIDProducto(String nombre) throws SQLException{        
        ResultSet rs = InventarioSql.LNOMBRE(nombre);
        int id = rs.getInt("idInventario");
        return id;
    }
    
}
