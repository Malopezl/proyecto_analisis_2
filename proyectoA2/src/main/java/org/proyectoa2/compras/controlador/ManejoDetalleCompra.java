/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.compras.controlador;

import java.util.ArrayList;
import org.marcos.dto.DetalleCompra;
import org.marcos.sql.DetalleCompraSql;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class ManejoDetalleCompra {
    private static ManejoDetalleCompra manejadorDetalle;
    private ArrayList<DetalleCompra> listaDetalle;
    private final DetalleCompraSql detallesql;

    public ManejoDetalleCompra() {
        listaDetalle = new ArrayList<>();
        detallesql = new DetalleCompraSql();
    }
    
    public static ManejoDetalleCompra obtenerDetalles() {
        if(manejadorDetalle == null){
            manejadorDetalle = new ManejoDetalleCompra();
        }
        return manejadorDetalle;
    }
    
    public ArrayList<DetalleCompra> getListaDetalles(){
        return listaDetalle;
        
    }
    
    public void actualizarDetalle(String factura){
        if(manejadorDetalle == null){
            manejadorDetalle = new ManejoDetalleCompra();
        }
        listaDetalle = detallesql.seleccionarDetalle();
    }
    
    public DetalleCompra getDetalleCompra(int index){
        return this.listaDetalle.get(index);
    }
}
