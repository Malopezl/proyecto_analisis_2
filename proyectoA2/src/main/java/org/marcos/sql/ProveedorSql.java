/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.sql;

import java.sql.*;
import java.util.ArrayList;
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
    
    public ArrayList<Proveedor> seleccionarProveedores(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Proveedor> lista = new ArrayList<>();
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaSeleccionar = "SELECT idProveedor, NIT, direccionProveedor, nombreProveedor, telefono FROM Proveedores";
            stmt = conn.prepareStatement(sentenciaSeleccionar);
            rs = stmt.executeQuery();
            Proveedor tmp;
            while(rs.next()){
                tmp = new Proveedor();
                tmp.setIdProveedor(rs.getInt(1));
                tmp.setNit(rs.getString(2));
                tmp.setDireccionProveedor(rs.getString(3));
                tmp.setNombreProveedor(rs.getString(4));
                tmp.setTelefono(rs.getString(5));
                lista.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return lista;
    }
}
