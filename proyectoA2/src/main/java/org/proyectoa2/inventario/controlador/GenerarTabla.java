/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.controlador;

import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Inventario;
import org.proyectoa2.inventario.interfaces.Opcion;

/**
 *
 * @author tito88
 */
public class GenerarTabla {

    private Opcion opcion;

    public DefaultTableModel GenerarTabla(String tipo, Inventario inventario) {
        Factory_RevisionInventario revisar = new Factory_RevisionInventario();
        this.opcion = revisar.CrearObjeto(tipo);
        return this.opcion.Crear(inventario);

    }
}
