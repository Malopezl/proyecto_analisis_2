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
import org.marcos.sql.DetalleCompraSql;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class ManejoCompra {
    private final CompraSql comprasql;
    private DetalleCompraSql detallesql;

    public ManejoCompra() {
        comprasql = new CompraSql();
    }
    
    public void registrarCompra(Compra compra) {
        comprasql.Insertar(compra);
    }
    
    public DefaultTableModel listarCompras(DefaultTableModel modeloTabla) {
        DefaultTableModel modelo = modeloTabla;
        ResultSet rs = CompraSql.mostrarMain();
        try {
            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
    
    public DefaultTableModel listarDetalle(DefaultTableModel modeloTabla, String factura) {
        DefaultTableModel modelo = modeloTabla;
        ResultSet rs = detallesql.mostrarDetalle(factura);
        try {
            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejoCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }
}
