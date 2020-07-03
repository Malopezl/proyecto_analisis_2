/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.vista.Controlador;

import java.util.Date;
import org.w3c.dom.Text;

/**
 *
 * @author tito88
 */
public class Tabla {
private int ID;
private Text Descripcion;
private int Existencia;
private Date Lote;
private Date FechaCaducidad;
private String Nombre;

    public Tabla(int ID, Text Descripcion, int Existencia, Date FechaCaducidad, String Nombre) {
        this.ID = ID;
        this.Descripcion = Descripcion;
        this.Existencia = Existencia;
        this.FechaCaducidad = FechaCaducidad;
        this.Nombre = Nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Text getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(Text Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public Date getFechaCaducidad() {
        return FechaCaducidad;
    }

    public void setFechaCaducidad(Date FechaCaducidad) {
        this.FechaCaducidad = FechaCaducidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
