/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.marcos.dto.Proveedor;

/**
 *
 * @author marcos
 * @author marvin
 */
public class ProveedorSql {

    /**
     *
     * @param nuevoProveedor
     * @return
     */
    public static int Insertar(Proveedor nuevoProveedor) {
        String sentenciaInsertar = "INSERT INTO Proveedor(NIT, No_cuenta, saldoPendiente, direccionProveedor, nombreProveedor, telefono, correo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try{
            conn = ConexionSql.getConnection();
            stmt = conn.prepareStatement(sentenciaInsertar);
            int index = 1;
            stmt.setString(index++, nuevoProveedor.getNit());
            stmt.setString(index++, nuevoProveedor.getNoCuenta());
            stmt.setDouble(index++, nuevoProveedor.getSaldoPendiente());
            stmt.setString(index++, nuevoProveedor.getDireccionProveedor());
            stmt.setString(index++, nuevoProveedor.getNombreProveedor());
            stmt.setString(index++, nuevoProveedor.getTelefono());
            stmt.setString(index++, nuevoProveedor.getCorreo());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrdenSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(rs);
                ConexionSql.close(conn);
            }
        }
        return rows;
    }
    
    /**
     *
     * @return
     */
    public static ResultSet mostrarProveedores() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT NIT, nombre, direccion, telefono FROM Proveedores";
            stmt = conn.prepareStatement(sentenciaBuscar);
            rs = stmt.executeQuery(sentenciaBuscar);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(rs);
                ConexionSql.close(conn);
            }
        }
        return rs;
    }
}
