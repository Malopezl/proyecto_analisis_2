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
    
    
    
    public static void AgregarMenu(String nombre, String descripcion, double precio, String receta, ArrayList<IngredienteMenu>ingredientes) throws SQLException{
      Menu menuNuevo = new Menu(nombre, descripcion, precio, receta, "CREADO");
      int idMenu = MenuSql.Insertar(menuNuevo);
      ControladorMenu.AgregarIngredientes(idMenu, ingredientes);    
    }
    private static void AgregarIngredientes(int idMenu, ArrayList<IngredienteMenu>ingredientes) throws SQLException{
        for (int i = 0; i < ingredientes.size(); i++) {
            ingredientes.get(i).setIdMenu(idMenu);
            
            // llamar a IngredienteMenu Sql
            // agregar las dimensiones del ingrediente

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
