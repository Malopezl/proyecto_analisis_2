/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import org.marcos.dto.IngredienteMenu;
import org.marcos.dto.Menu;
import org.marcos.sql.IngredienteMenuSql;
import org.marcos.sql.MenuSql;

/**
 *
 * @author sharon
 */
public class ControladorMenu {
    
    
    
    public static boolean AgregarMenu(String nombre, String descripcion, double precio, String receta, ArrayList<IngredienteMenu>ingredientes) throws SQLException{
      Menu menuNuevo = new Menu(nombre, descripcion, precio, receta, "CREADO");
      int idMenu = MenuSql.Insertar(menuNuevo);
      ControladorMenu.AgregarIngredientes(idMenu, ingredientes);
      return true;
    }
    private static void AgregarIngredientes(int idMenu, ArrayList<IngredienteMenu>ingredientes) throws SQLException{
        for (int i = 0; i < ingredientes.size(); i++) {
            ingredientes.get(i).setIdMenu(idMenu);
            IngredienteMenuSql.INSERTAR(ingredientes.get(i));
        }

    }
    public static boolean EditarMenu(int idMenu, String nombre, String descripcion, double precio, String receta,String estado, ArrayList<IngredienteMenu>ingredientes) throws SQLException{
      Menu menuActualizado = new Menu(nombre, descripcion, precio, receta, estado);
      menuActualizado.setIdMenu(idMenu);
      MenuSql.ACTUALIZAR(menuActualizado);
      IngredienteMenuSql.ELIMINARMENU(idMenu);
      ControladorMenu.ActualizarIngredientes(idMenu, ingredientes);
      return true; 
    }
    private static void ActualizarIngredientes(int idMenu, ArrayList<IngredienteMenu>ingredientes) throws SQLException{
      ControladorMenu.AgregarIngredientes(idMenu, ingredientes);  
    }
    
    public static boolean EliminarMenu(int idMenu){
        IngredienteMenuSql.ELIMINARMENU(idMenu);
        MenuSql.ELIMINAR(idMenu);
        return true;
    }
    public void notificar(){
        
    }
    
    
}
