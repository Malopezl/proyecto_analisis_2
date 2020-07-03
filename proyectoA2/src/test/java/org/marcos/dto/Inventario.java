/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.dto;

import java.util.Date;

/**
 *
 * @author marcos
 */
public class Inventario {
    private int idInventario;
    private String descripcionInventario;
    private int existencia;
    private String lote;
    private Date fechaCaducidad;
    private String nombre;
    
    
    public Inventario() {
    }

    public Inventario(int idInventario, String descripcionInventario, int existencia, String lote, Date fechaCaducidad, String nombre) {
        this.idInventario = idInventario;
        this.descripcionInventario = descripcionInventario;
        this.existencia = existencia;
        this.lote = lote;
        this.fechaCaducidad = fechaCaducidad;
        this.nombre = nombre;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getDescripcionInventario() {
        return descripcionInventario;
    }

    public void setDescripcionInventario(String descripcionInventario) {
        this.descripcionInventario = descripcionInventario;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
