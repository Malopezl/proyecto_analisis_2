/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import org.marcos.dto.Orden;

/**
 *
 * @author marcos
 */
public abstract class RealizarPago {
    
    public void generarFactura(){
        System.out.println("esto es una factura");
    }
    public abstract void realizarPago(Orden cobrar);
}
