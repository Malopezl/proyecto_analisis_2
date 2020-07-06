/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.interfaces;

import java.util.Date;
import org.marcos.dto.Inventario;

/**
 *
 * @author Gilda
 */
public interface TipoProducto {
    public Inventario tipoProducto(Date fecha, Inventario inventario);
}
