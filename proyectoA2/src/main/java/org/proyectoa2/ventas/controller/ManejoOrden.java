/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import java.util.ArrayList;
import java.util.Date;
import org.marcos.dto.Cliente;
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
        double total ;
        total = detalle.getSubTotal();
        for(int i = 0 ; i <  detalle.getCantidad(); i++){
            for(DetalleComplementos item : detalle.getListaComplementos()){
                total += item.getSubTotal();
            }
        
        }
        return total;
    }
    public void eliminarPlatillo(int indice){
        orden.getDetalles().remove(indice);
    }
    public void prepararOrden(Cliente cliente, String total){
        this.orden.setCliente(cliente);
        Date fecha = new Date();
        this.orden.setFechaOrden(fecha);
        this.orden.setIdCliente(cliente.getIdCliente());
        this.orden.setIdUsuario(1);
        this.orden.setTotal(Double.valueOf(total));
    }
}
