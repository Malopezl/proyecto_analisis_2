/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.proveedores.controlador;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class BusquedasProveedores {

    /**
     *
     * @param tipo
     * @return
     */
    public BusquedaProveedor mostrar(String tipo) {
        switch (tipo) {
            case "Nit" -> {
                return new BuscarNit();
            }
            case "Nombre" -> {
                return new BuscarNombre();
            }
        }
        return null;
    }
}
