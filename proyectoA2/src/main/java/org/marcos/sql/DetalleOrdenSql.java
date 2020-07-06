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
import org.marcos.dto.DetalleOrden;

/**
 *
 * @author marcos
 */
public class DetalleOrdenSql {
    
    
    public int insertarListaDetalleOrden(ArrayList<DetalleOrden> lista){
        String sentencia = "INSERT INTO DetalleOrden(idOrden, idMenu, cantidad, precioVenta, subtotal) VALUES(?, ?, ?, ?, ?) ";
        Connection conn = null;
        int rows = 0;
        int tmp;
        PreparedStatement stmt = null;
        int indice = 1;
        try{
            conn = ConexionSql.getConnection();
            for(DetalleOrden detalle : lista){
                stmt = conn.prepareStatement(sentencia);
                stmt.setInt(indice++, detalle.getIdOrden());
                stmt.setInt(indice++, detalle.getIdMenu());
                stmt.setInt(indice++, detalle.getCantidad());
                stmt.setDouble(indice++, detalle.getPrecioVenta());
                stmt.setDouble(indice, detalle.getSubTotal());
                indice = 1;
                
                tmp = stmt.executeUpdate();
                rows = tmp + rows;
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(DetalleOrdenSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
}
