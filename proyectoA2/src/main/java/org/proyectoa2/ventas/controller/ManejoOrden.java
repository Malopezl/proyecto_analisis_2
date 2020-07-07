/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import java.util.ArrayList;
import org.marcos.dto.DetalleComplementos;
import org.marcos.dto.DetalleOrden;
import org.marcos.dto.Orden;

/**
 *
 * @author marcos
 */
public class ManejoOrden {
    private Orden orden;
    private ManejoColaOrdenes manejadorColaOrdenes;

    
    
    public ManejoOrden(){
        manejadorColaOrdenes = ManejoColaOrdenes.obtenerControlador();
        this.orden = new Orden();
    }
    public ManejoOrden(Orden orden){
        manejadorColaOrdenes = ManejoColaOrdenes.obtenerControlador();
        this.orden = orden;
    }
    public void agregarDetalleOrden(DetalleOrden detalleOrden){
        orden.addDetalleOrden(detalleOrden);
    }
    public void confirmarOrden(){
        manejadorColaOrdenes.agregarNuevaOrden(orden);
    }
    public void confirmarModificacionOrden(){
        manejadorColaOrdenes.editarOrden(orden);
    }
    public Orden getOrden(){
        return orden;
    }
    public double getTotalDetalle(DetalleOrden detalle){
        double total;
        total = detalle.getSubTotal();
        System.out.println("total = " + total);
        for(DetalleComplementos item : detalle.getListaComplementos()){
            total += item.getSubTotal();
        }
        return total;
    }
}
