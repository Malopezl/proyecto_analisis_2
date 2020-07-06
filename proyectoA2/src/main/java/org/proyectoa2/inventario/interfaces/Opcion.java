/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.interfaces;

import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Inventario;

/**
 *
 * @author tito88
 */
public interface Opcion {
    public DefaultTableModel Crear(Inventario inventario);
}
