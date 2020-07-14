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
    public int Insertar(Proveedor nuevoProveedor) {
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
            String sentenciaSeleccionar = "SELECT idProveedor, NIT, direccionProveedor, nombreProveedor, telefono FROM Proveedor";
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
    
    public ResultSet listarPorNit(String nit) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT NIT, nombreProveedor, No_cuenta, telefono, direccionProveedor, correo, saldoPendiente FROM Proveedor "
                      + "where NIT LIKE '%" + nit + "%'";
            stmt = conn.prepareStatement(sentenciaBuscar);
            rs = stmt.executeQuery(sentenciaBuscar);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return rs;
    }
    
    public ResultSet listarPorNombre(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT NIT, nombreProveedor, No_cuenta, telefono, direccionProveedor, correo, saldoPendiente FROM Proveedor "
                      + "where nombreProveedor LIKE '%" + nombre + "%'";
            stmt = conn.prepareStatement(sentenciaBuscar);
            rs = stmt.executeQuery(sentenciaBuscar);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return rs;
    }
    
    public int actualizarSaldo(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionSql.getConnection();
            String sentenciaActualizarSaldo = "UPDATE Proveedor SET saldoPendiente=? WHERE idProveedor=?";
            stmt = conn.prepareStatement(sentenciaActualizarSaldo);
            stmt.setDouble(1, proveedor.getSaldoPendiente());
            stmt.setInt(2, proveedor.getIdProveedor());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return rows;
    }
    
    public int actualizarProveedores(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionSql.getConnection();
            String sentenciaActualizar = "UPDATE Proveedor SET nombreProveedor=?, direccionProveedor=?, telefono=?, correo=? WHERE NIT=?";
            stmt = conn.prepareStatement(sentenciaActualizar);
            stmt.setString(1, proveedor.getNombreProveedor());
            stmt.setString(2, proveedor.getDireccionProveedor());
            stmt.setString(3, proveedor.getTelefono());
            stmt.setString(4, proveedor.getCorreo());
            stmt.setString(5, proveedor.getNit());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return rows;
    }
    
    public int eliminarProveedor(Proveedor proveedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = ConexionSql.getConnection();
            String sentenciaEliminar = "DELETE FROM Proveedor WHERE NIT=?";
            stmt = conn.prepareStatement(sentenciaEliminar);
            stmt.setString(1, proveedor.getNit());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return rows;
    }
    
    public static ResultSet listarProveedores() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT NIT, No_cuenta, nombreProveedor, telefono, direccionProveedor, correo, saldoPendiente FROM Proveedor";
            stmt = conn.prepareStatement(sentenciaBuscar);
            rs = stmt.executeQuery(sentenciaBuscar);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return rs;
    }
}
