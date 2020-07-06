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
public class Perecedero implements TipoProducto {

    @Override
    public Inventario tipoProducto(Date fecha, Inventario inventario) {
        try {
            String fecha1 = "0000-00-00";
            Date fecha2 = new SimpleDateFormat("yyyy-mm-dd").parse(fecha1);
            inventario.setFechaCaducidad(fecha2);
            return (inventario);
        } catch (ParseException ex) {
            Logger.getLogger(NoPerecedero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventario;
    }

}
