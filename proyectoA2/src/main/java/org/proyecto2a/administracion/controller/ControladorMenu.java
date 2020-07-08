/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.controller;

import java.util.ArrayList;
import org.marcos.dto.IngredienteMenu;
import org.marcos.dto.Menu;

/**
 *
 * @author sharon
 */
public class ControladorMenu {
    
    
    
    public void AgregarMenu(String nombre, String descripcion, double precio, String receta){
      Menu menuNuevo = new Menu(nombre, descripcion, precio, receta, "CREADO");
      
     
    }
    public void EditarMenu(){
        
    }
    public void VerMenu(){
        
    }
    public void notificar(){
        
    }
    
}
