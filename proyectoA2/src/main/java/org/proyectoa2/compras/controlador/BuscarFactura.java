/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.compras.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Compra;
import org.marcos.sql.CompraSql;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class BuscarFactura implements BusquedaCompra{
    private CompraSql CompraSql = new CompraSql();
    
    /**
     *
     * @param modelo
     * @param compra
     * @return
     */
    @Override
    public DefaultTableModel mostrar(DefaultTableModel modelo, Compra compra) {
        DefaultTableModel model = modelo;
        
        try {
            String factura = compra.getNoFactura();
            ResultSet rs = CompraSql.listarPorFactura(factura);

            while (rs.next()) {
                Object[] fila = new Object[4];
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BuscarFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

}
