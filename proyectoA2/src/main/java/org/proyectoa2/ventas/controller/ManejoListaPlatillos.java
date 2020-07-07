/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import java.util.ArrayList;
import org.marcos.dto.Menu;
import org.marcos.sql.MenuSql;
/**
 *
 * @author marcos
 */
public class ManejoListaPlatillos {
    private ArrayList<Menu> listaPlatillos;
    private static ManejoListaPlatillos manejadorListaPlatillos;
    
    private ManejoListaPlatillos(){
        MenuSql menu = new MenuSql();
        listaPlatillos = menu.getAllMenu();
    }
    public static ManejoListaPlatillos getManejador(){
        if(manejadorListaPlatillos == null){
            manejadorListaPlatillos = new ManejoListaPlatillos();
        }
        
        return manejadorListaPlatillos;
    }
    public ArrayList<Menu> getListaPlatillos(){
        return listaPlatillos;
    }
    public Menu getPlatillo(int indice){
        return listaPlatillos.get(indice);
    }
    
    
}
