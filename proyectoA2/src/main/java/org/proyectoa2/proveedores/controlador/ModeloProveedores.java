/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.proveedores.controlador;

import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Proveedor;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class ModeloProveedores {
    private BusquedaProveedor busqueda;
    
    /**
     *
     * @param tipo
     * @param proveedor
     * @param modelo
     * @return
     */
    public DefaultTableModel ModeloProveedores(String tipo, Proveedor proveedor, DefaultTableModel modelo) {
        BusquedasProveedores buscar = new BusquedasProveedores();
        this.busqueda = buscar.mostrar(tipo);
        return this.busqueda.mostrar(modelo, proveedor);
    }
}
