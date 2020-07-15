/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.controller;

import org.marcos.dto.Puesto;
import org.marcos.sql.PuestoSql;

/**
 *
 * @author sharon
 */
public class ControladorPuesto {
    public static void AgregarPuesto(String nombre, String descripcion, String Rol){
        Puesto puesto = new Puesto();
        puesto.setNombre(nombre);
        puesto.setDescripcion(descripcion);
        puesto.setRol(Rol);
        PuestoSql.INSERTAR(puesto);
    }
    public static void EditarPuesto(Puesto puesto){
        PuestoSql.ACTUALIZAR(puesto);
    }
    public static void ElminarPuesto(Puesto puesto){
        PuestoSql.ELIMINAR(puesto.getId());
    }
}
