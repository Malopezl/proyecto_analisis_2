/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.controlador;

import org.proyectoa2.inventario.controlador.listar.Revision_FechaCaducidad;
import org.proyectoa2.inventario.controlador.listar.Revision_existencia;
import org.proyectoa2.inventario.controlador.listar.Revision_general;
import org.proyectoa2.inventario.controlador.listar.Revision_nombre;
import org.proyectoa2.inventario.interfaces.Opcion;

/**
 *
 * @author tito88
 */
public class Factory_RevisionInventario {

    public Opcion CrearObjeto(String tipo) {
        switch (tipo) {
            case "General": {
                return new Revision_general();

            }
            case "Nombre": {
                return new Revision_nombre();
            }

            case "Existencia": {
                return new Revision_existencia();
            }
            case "Fecha": {
                return new Revision_FechaCaducidad();

            }
        }

        return null;
    }
}
