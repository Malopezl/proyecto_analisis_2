/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import java.util.ArrayList;
import org.marcos.dto.Inventario;
import org.marcos.sql.InventarioSql;

/**
 *
 * @author marcos
 */
public class ManejoListaComplementos {
    private static ManejoListaComplementos manejador;
    private ArrayList<Inventario> lista;
    
    private ManejoListaComplementos(){
        InventarioSql inventario = new InventarioSql();
        lista = inventario.selectAll();
        
    }
    public static ManejoListaComplementos getManejador(){
        if(manejador == null){
            manejador = new ManejoListaComplementos();
        }
        
        return manejador;
    }
    public ArrayList<Inventario> getListaComplementos(){
        return lista;
    }
    public Inventario getComplemento(int indice){
        return lista.get(indice);
    }
    public void ActualizarListaComplementos(){
        InventarioSql inventario = new InventarioSql();
        lista = inventario.selectAll();
    }
}
