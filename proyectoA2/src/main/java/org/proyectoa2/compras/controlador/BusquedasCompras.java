/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.compras.controlador;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class BusquedasCompras {

    /**
     *
     * @param tipo
     * @return
     */
    public BusquedaCompra mostrar (String tipo) {
        switch (tipo) {
            case "Factura" -> {
                return new BuscarFactura();
            }
            case "Fecha" -> {
                return new BuscarFecha();
            }
            case "Proveedor" -> {
                return new BuscarProveedor();
            }
        }
        return null;
    }
}
