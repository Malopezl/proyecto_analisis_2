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
public class IngredienteMenu {
    private int idMenu;
    private int idInventario;
    private double cantidad;
    private Inventario inventario;
    private Menu menu;
    
    public IngredienteMenu() {
    }

    public IngredienteMenu(int idMenu, int idInventario, double cantidad) {
        this.idMenu = idMenu;
        this.idInventario = idInventario;
        this.cantidad = cantidad;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    
}
