/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.marcos.dto.Compra;

/**
 *
 * @author marcos
 * @author marvin
 */
public class CompraSql {

    /**
     *
     * @param nuevaCompra
     * @return
     */
    public int Insertar(Compra nuevaCompra) {
        String sentenciaInsertarCompra = "INSERT INTO Compra(fecha, no_factura, total, idProveedor) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try {
            conn = ConexionSql.getConnection();
            stmt = conn.prepareStatement(sentenciaInsertarCompra);
            stmt.setDate(1, (Date) nuevaCompra.getFecha());
            stmt.setString(2, nuevaCompra.getNoFactura());
            stmt.setDouble(3, nuevaCompra.getTotal());
            stmt.setInt(4, nuevaCompra.getIdProveedor());
            rows = stmt.executeUpdate();
            
            String sentencia = "SELECT idCompra FROM Compra WHERE Proveedor_idProveedor = ? AND no_factura = ?";
            stmt = conn.prepareStatement(sentencia);
            stmt.setInt(1, nuevaCompra.getIdProveedor());
            stmt.setString(2, nuevaCompra.getNoFactura());
            rs = stmt.executeQuery();
            int id = rs.getInt(1);
            nuevaCompra.setIdCompra(id);
            DetalleCompraSql detalle = new DetalleCompraSql();
            detalle.InsertarListado(nuevaCompra.getDetalles(), id);
        } catch (SQLException ex) {
            Logger.getLogger(OrdenSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null) {
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
    public static ResultSet listarCompras() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT c.no_factura, c.fecha, p.nombreProveedor, c.total FROM Proveedor p INNER JOIN Compra c on p.idProveedor = c.idProveedor";
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
    
    /**
     *
     * @param fecha
     * @return
     */
    public static ResultSet listarPorFecha(String fecha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT c.no_factura, c.fecha, p.nombreProveedor, c.total FROM Proveedor p INNER JOIN Compra c on p.idProveedor = c.idProveedor "
                      + "where c.fecha LIKE '%" + fecha + "%'";
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
    
    /**
     *
     * @param factura
     * @return
     */
    public static ResultSet listarPorFactura(String factura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT c.no_factura, c.fecha, p.nombreProveedor, c.total FROM Proveedor p INNER JOIN Compra c on p.idProveedor = c.idProveedor "
                      + "where c.no_factura LIKE '%" + factura + "%'";
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
    
    /**
     *
     * @param nombre
     * @return
     */
    public static ResultSet listarPorProveedor(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT c.no_factura, c.fecha, p.nombreProveedor, c.total FROM Proveedor p INNER JOIN Compra c on p.idProveedor = c.idProveedor "
                      + "where p.nombreProveedor LIKE '%" + nombre + "%'";
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
