/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import java.util.ArrayList;
import org.marcos.dto.DetalleOrden;
import org.marcos.dto.Orden;

/**
 *
 * @author marcos
 */
public class ManejoOrden {
    private Orden orden;
    private ManejoColaOrdenes manejadorColaOrdenes;
    
    
    public void ManejoOrdenes(){
        manejadorColaOrdenes = ManejoColaOrdenes.obtenerControlador();
    }
    
    public void crearOrden(){
        
    }
    public void agregarDetalleOrden(DetalleOrden detalleOrden){

    }
    public void confirmarOrden(Orden orden){
        manejadorColaOrdenes.agregarNuevaOrden(orden);
    }
    public void setOrden(Orden orden){
        
    }
}
