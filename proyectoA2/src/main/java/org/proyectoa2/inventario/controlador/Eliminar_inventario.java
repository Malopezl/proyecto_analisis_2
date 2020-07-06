/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.controlador;

import static javax.swing.text.html.HTML.Attribute.ID;
import org.marcos.dto.Inventario;
import static org.marcos.sql.InventarioSql.ELIMINAR;
import static org.marcos.sql.InventarioSql.Insertar;
import org.proyectoa2.inventario.interfaces.TipoProducto;

/**
 *
 * @author tito88
 */
public class Eliminar_inventario {

    public void Eliminar(int id) {

        String g = ELIMINAR(id);
    }
}
