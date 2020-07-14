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
public class ManejoProveedor {
    private final Proveedor proveedor;
    private final ProveedorSql proveedorSql;
    
    public ManejoProveedor() {
        proveedor = new Proveedor();
        proveedorSql = new ProveedorSql();
    }
    
    public ManejoProveedor(Proveedor p) {
        this.proveedor = p;
        proveedorSql = new ProveedorSql();
    }
    
    public void registrarProveedor(Proveedor p) {
        proveedorSql.Insertar(p);
    }
    
    public void actualizarProveedores(Proveedor p) {
        proveedorSql.actualizarProveedores(p);
    }
    
    public void eliminarProveedores(Proveedor p) {
        proveedorSql.eliminarProveedor(p);
    }
    
    public DefaultTableModel listarProveedores(DefaultTableModel modelo) {
        DefaultTableModel model = modelo;
        ResultSet rs = ProveedorSql.listarProveedores();
        
        try {
            while (rs.next()) {
                Object[] fila = new Object[7];
                
                for (int i = 0; i < 7; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejoProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
}
