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
    private double total;
    private int idUsuario;
    private int idCliente;
    private Cliente cliente;
    private Usuario usuario;
    private ArrayList<DetalleOrden> detalles;
    private int estado;
    // estado 1 = en espera, estado 2 = atendido
    public Orden() {
        detalles = new ArrayList<>();
        
    }

    public Orden(String noFactura, Date fechaOrden, double total, int idUsuario, int idCliente) {
         detalles = new ArrayList<>();
        this.noFactura = noFactura;
        this.fechaOrden = fechaOrden;
        this.total = total;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void addDetalleOrden(DetalleOrden detalle){
        detalles.add(detalle);
    }


    @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", noFactura=" + noFactura + ", fechaOrden=" + fechaOrden + ", subTotal=" + total + ", idUsuario=" + idUsuario + ", idCliente=" + idCliente + ", detalles=" + detalles + '}';
    }
    
    
    
    
}
