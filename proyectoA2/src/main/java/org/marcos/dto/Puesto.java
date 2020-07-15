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
public class Puesto {
    public int id;
    public String nombre;
    public String descripcion;
    public String rol;

    public Puesto() {
    }

    public Puesto(int id, String nombre, String descripcion, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rol = rol;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Puesto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion +", rol="+ rol+ '}';
    }
    
    
            
}
