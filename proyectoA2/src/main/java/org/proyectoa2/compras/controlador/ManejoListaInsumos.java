/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.compras.controlador;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Inventario;
import org.marcos.sql.InventarioSql;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class ManejoListaInsumos {
    private static ManejoListaInsumos manejadorInsumos;
    private ArrayList<Inventario> listaInsumos;
    private final InventarioSql inventariosql;

    public ManejoListaInsumos() {
        listaInsumos = new ArrayList<>();
        inventariosql = new InventarioSql();
    }
    
    public static ManejoListaInsumos obtenerInsumos() {
        if(manejadorInsumos == null){
            manejadorInsumos = new ManejoListaInsumos();
        }
        return manejadorInsumos;
    }
    
    public ArrayList<Inventario> getListaInsumos(){
        return listaInsumos;
        
    }
    
    public void actualizarInsumos(){
        if(manejadorInsumos == null){
            manejadorInsumos = new ManejoListaInsumos();
        }
        listaInsumos = inventariosql.selectAll();
    }
    
    public Inventario getInsumo(int index){
        return this.listaInsumos.get(index);
    }
    
    public Inventario getInsumo(String nombre) {
        Inventario tmp = new Inventario();
        
        for (Inventario listaInsumo : listaInsumos) {
            if (listaInsumo.getNombre().equals(nombre))
                tmp = listaInsumo;
        }
        return tmp;
    }
    
    public DefaultTableModel mostrarExistencias(DefaultTableModel modelo) {
        DefaultTableModel model = modelo;
        this.actualizarInsumos();
        
        listaInsumos.stream().map(insumo -> {
            Object[] fila = new Object[3];
            fila[0] = insumo.getIdInventario();
            fila[1] = insumo.getNombre();
            fila[2] = insumo.getExistencia();
            return fila;
        }).forEachOrdered(fila -> {
            model.addRow(fila);
        });
        return model;
    }
}
