/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.proveedores.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Proveedor;
import org.marcos.sql.ProveedorSql;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class BuscarNombre implements BusquedaProveedor {
    private ProveedorSql proveedorSql = new ProveedorSql();
    
    /**
     *
     * @param modelo
     * @param proveedor
     * @return
     */
    @Override
    public DefaultTableModel mostrar(DefaultTableModel modelo, Proveedor proveedor) {
        DefaultTableModel model = modelo;

        try {
            String nombre = proveedor.getNombreProveedor();
            ResultSet rs = proveedorSql.listarPorNombre(nombre);
            while (rs.next()) {
                Object[] fila = new Object[7];
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarNit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }

}
