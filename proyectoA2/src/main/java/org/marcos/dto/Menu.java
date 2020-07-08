/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.dto;

import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public class Menu {
    private int idMenu;
    private String nombreMenu;
    private String descripcionMenu;
    private double precio;
    private String receta;
    private String estado;
    private ArrayList<IngredienteMenu> ingredientes;
    

    public Menu() {
        this.ingredientes= new ArrayList<>();
    }

    public Menu(String nombreMenu, String descripcionMenu, double precio, String receta, String estado) {
        this.nombreMenu = nombreMenu;
        this.descripcionMenu = descripcionMenu;
        this.precio = precio;
        this.receta = receta;
        this.estado = estado;
        this.ingredientes= new ArrayList<>();
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
    }

    public String getDescripcionMenu() {
        return descripcionMenu;
    }

    public void setDescripcionMenu(String descripcionMenu) {
        this.descripcionMenu = descripcionMenu;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<IngredienteMenu> getIngredientes() {
        return ingredientes;
    }

    public void addIngredientes(IngredienteMenu ingrediente) {
        this.ingredientes = ingredientes;
    }

    
    @Override
    public String toString() {
        return "Menu{" + "idMenu=" + idMenu + ", nombreMenu=" + nombreMenu + ", descripcionMenu=" + descripcionMenu + ", precio=" + precio + ", receta=" + receta + ", estado=" + estado + '}';
    }
    
    
}
