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
 * @author marvin
 */
public class Compra {

    private int idCompra;
    private Date fecha;
    private String noFactura;
    private double total;
    private int idProveedor;
    private Proveedor proveedor;
    private ArrayList<DetalleCompra> detalles;

    public Compra() {
        detalles = new ArrayList<>();
    }

    public Compra(int idCompra, Date fecha, String noFactura, double total, int idProveedor) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.noFactura = noFactura;
        this.total = total;
        this.idProveedor = idProveedor;
        detalles = new ArrayList<>();
    }
    
    

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public ArrayList<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

    public void addDetalle(DetalleCompra detalle) {
        detalles.add(detalle);
    }
    
}
