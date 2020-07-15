/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.compras.controlador;

import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Compra;

/**
 *
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public interface BusquedaCompra {
    public DefaultTableModel mostrar(DefaultTableModel modelo, Compra compra);
}
