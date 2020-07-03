/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.dto;

/**
 *
 * @author marcos
 */
public class DetalleOrden {
    private int idOrden;
    private int idMenu;
    private int cantidad;
    private double precioVenta;
    private double total;
    private Menu menu;
    private Orden orden;
    
    public DetalleOrden() {
    }

    public DetalleOrden(int idOrden, int idMenu, int cantidad, double precioVenta) {
        this.idOrden = idOrden;
        this.idMenu = idMenu;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }

    
    
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
    
    
    
}
