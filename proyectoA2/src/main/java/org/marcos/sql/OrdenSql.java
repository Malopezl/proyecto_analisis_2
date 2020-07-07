/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.sql;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.marcos.dto.Orden;

/**
 *
 * @author marcos
 */
public class OrdenSql {
    private String sentenciaInsertNuevaOrden = "INSERT INTO Orden(No_factura, fechaOrden, total, Usuario_idUsuario, Cliente_idCliente) VALUES (?, ?, ?, ?, ?) ";
    
    public OrdenSql(){
        
    };
    
    public int insertNuevaOrden(Orden nuevaOrden){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        java.sql.Date convertidor;
        int rows = 0;
        try{
            conn = ConexionSql.getConnection();
            stmt = conn.prepareStatement(this.sentenciaInsertNuevaOrden);
            int index = 1;
            stmt.setString(index++, nuevaOrden.getNoFactura());
            convertidor = new java.sql.Date(nuevaOrden.getFechaOrden().getTime());
            stmt.setDate(index++, convertidor);
            stmt.setDouble(index++, nuevaOrden.getTotal());
            stmt.setInt(index++, nuevaOrden.getIdUsuario());
            stmt.setInt(index++, nuevaOrden.getIdCliente());
            rows = stmt.executeUpdate();
            String sentencia = "Select idOrden from Orden where Usuario_idUsuario = ? AND Cliente_idCliente = ? AND fechaOrden = ? AND No_factura = ?";
            stmt = conn.prepareStatement(sentencia);
            stmt.setInt(1, nuevaOrden.getIdUsuario());
            stmt.setInt(2, nuevaOrden.getIdCliente());
            stmt.setDate(3, convertidor);
            stmt.setString(4, nuevaOrden.getNoFactura());
            rs = stmt.executeQuery();
            int id = 0;
            while(rs.next()){
                id = rs.getInt(1);
                break;
            }
            nuevaOrden.setIdOrden(id);
            DetalleOrdenSql detalle = new DetalleOrdenSql();
            detalle.insertarListaDetalleOrden(nuevaOrden.getDetalles(), id);
            
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
}
