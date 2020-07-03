/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.dto;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author marcos
 */
public class Orden {
    private int idOrden;
    private String noFactura;
    private Date fechaOrden;
    private double subTotal;
    private int idUsuario;
    private int idCliente;
    private ArrayList<DetalleOrden> detalles;

    public Orden() {
    }

    public Orden(String noFactura, Date fechaOrden, double subTotal, int idUsuario, int idCliente) {
        this.noFactura = noFactura;
        this.fechaOrden = fechaOrden;
        this.subTotal = subTotal;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
    }
    
    

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<DetalleOrden> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleOrden> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", noFactura=" + noFactura + ", fechaOrden=" + fechaOrden + ", subTotal=" + subTotal + ", idUsuario=" + idUsuario + ", idCliente=" + idCliente + ", detalles=" + detalles + '}';
    }
    
    
    
    
}
