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
import org.marcos.dto.Compra;
import org.marcos.dto.DetalleCompra;
import org.marcos.dto.Proveedor;

/**
 *
 * @author marcos
 * @author marvin
 */
public class DetalleCompraSql {
    public int InsertarListado(ArrayList<DetalleCompra> lista, int idCompra) {
        String sentenciaInsertar = "INSERT INTO DetalleCompra(idCompra, idInventario, cantidad, subtotal, precio) VALUES(?, ?, ?, ?, ?)";
        Connection conn;
        PreparedStatement stmt;
        int rows = 0;
        int tmp;
        
        try {
            conn = ConexionSql.getConnection();
            for (DetalleCompra detalle : lista) {
                stmt = conn.prepareStatement(sentenciaInsertar);
                stmt.setInt(1, idCompra);
                stmt.setInt(2, detalle.getIdInventario());
                stmt.setFloat(3, detalle.getCantidad());
                stmt.setDouble(4, detalle.getSubtotal());
                stmt.setDouble(5, detalle.getPrecio());
                tmp = stmt.executeUpdate();
                rows = tmp + rows;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleOrdenSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
    public Compra obtenerDetalle(String factura) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Compra compra = new Compra();
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT idCompra, fecha, no_factura, total, idProveedor FROM Compra WHERE no_factura LIKE '%" + factura + "%'";
            stmt = conn.prepareStatement(sentenciaBuscar);
            rs = stmt.executeQuery(sentenciaBuscar);
            
            while (rs.next()) {
                compra.setIdCompra(rs.getInt(1));
                compra.setFecha(rs.getDate(2));
                compra.setNoFactura(rs.getString(3));
                compra.setTotal(rs.getDouble(4));
                compra.setIdProveedor(rs.getInt(5));
            }
            
            String sentencia = "SELECT nombreProveedor FROM Proveedor WHERE idProveedor = ?";
            stmt = conn.prepareStatement(sentencia);
            stmt.setInt(1, compra.getIdProveedor());
            rs = stmt.executeQuery(sentencia);
            Proveedor proveedor = new Proveedor();
            proveedor.setNombreProveedor(rs.getString(1));
            compra.setProveedor(proveedor);
            
        } catch (SQLException ex) {
            Logger.getLogger(OrdenSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return compra;
    }
    
    public ResultSet seleccionarDetalle(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaSeleccionar = "SELECT i.nombre, dc.precio, dc.cantidad, dc.subtotal FROM detalleCompra dc INNER JOIN Inventario i ON dc.idInventario = i.idInventario "
                      + "where dc.idCompra LIKE '%" + id + "%'";
            stmt = conn.prepareStatement(sentenciaSeleccionar);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return rs;
    }
}
