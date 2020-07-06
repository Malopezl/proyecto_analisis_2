/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.marcos.dto.Inventario;
import org.proyectoa2.inventario.interfaces.TipoProducto;

/**
 *
 * @author tito88
 */
public class NoPerecedero implements TipoProducto {

    @Override
    public Inventario tipoProducto(Date fecha, Inventario inventario) {
        return inventario;

    }

}
