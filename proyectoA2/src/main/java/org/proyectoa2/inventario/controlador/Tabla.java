/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.controlador;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tito88
 */
public class Tabla {

    private DefaultTableModel modelo;

    public Tabla() {
        this.modelo = new DefaultTableModel();
        this.modelo.addColumn("Id");
        this.modelo.addColumn("Nombre");
        this.modelo.addColumn("Descripcion");
        this.modelo.addColumn("Existencia");
        this.modelo.addColumn("Lote");
        this.modelo.addColumn("Fecha Caducidad");

    }

    public DefaultTableModel getModelo() {
        return this.modelo;
    }

}
