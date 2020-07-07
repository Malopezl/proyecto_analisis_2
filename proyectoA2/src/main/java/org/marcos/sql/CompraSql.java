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
    public static int Insertar(Compra nuevaCompra) {
        String sentenciaInsertar = "INSERT INTO Compra(fecha, no_factura, total, estado, Proveedor_idProveedor) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        
        try {
            conn = ConexionSql.getConnection();
            stmt = conn.prepareStatement(sentenciaInsertar);
            int index = 1;
            stmt.setDate(index++, (Date) nuevaCompra.getFecha());
            stmt.setString(index++, nuevaCompra.getNoFactura());
            stmt.setDouble(index++, nuevaCompra.getTotal());
            stmt.setString(index++, nuevaCompra.getEstado());
            stmt.setInt(index++, nuevaCompra.getIdProveedor());
            rows = stmt.executeUpdate();
            
            String sentencia = "SELECT idCompra FROM Compra WHERE Proveedor_idProveedor = ? AND No_factura = ?";
            stmt = conn.prepareStatement(sentencia);
            stmt.setInt(1, nuevaCompra.getIdProveedor());
            stmt.setString(2, nuevaCompra.getNoFactura());
            rs = stmt.executeQuery();
            int id = rs.getInt(1);
            nuevaCompra.setIdCompra(id);
            DetalleCompraSql detalle = new DetalleCompraSql();
            detalle.InsertarListado(nuevaCompra.getDetalle(), id);
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
    
    public static ResultSet mostrarMain() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT c.no_factura, p.nombre, c.fecha, c.total FROM Proveedores p INNER JOIN Compra c on p.idProveedor = c.idProveedor";
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
    
    public static ResultSet mostrarInsumos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT i.nombre FROM Inventario";
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
