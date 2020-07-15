/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.compras.controlador;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Compra;
import org.marcos.sql.CompraSql;


/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class BuscarFecha implements BusquedaCompra{
    private CompraSql CompraSql = new CompraSql();
    
    @Override
    public DefaultTableModel mostrar(DefaultTableModel modelo, Compra compra) {
        DefaultTableModel model = modelo;
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = sdf.format(compra.getFecha());
            ResultSet rs = CompraSql.listarPorFecha(fecha);

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BuscarFecha.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
}
