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
import org.marcos.dto.DetalleComplementos;

/**
 *
 * @author marcos
 */
public class DetalleComplementosSql {
    private final String statementInsertarDetalles = "INSERT INTO DetalleComplementos(idOrden, idInventario, cantidad, precioVenta, subTotal, idMenu) VALUES(?, ?, ?, ?, ?, ?) ";
    
    
    public int insertarDetallleCompelementosVenta(ArrayList<DetalleComplementos> lista, int idOrden, int idMenu){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        int tmp;
        try{
            conn = ConexionSql.getConnection();
            for(DetalleComplementos item : lista){
                stmt = conn.prepareStatement(statementInsertarDetalles);
                stmt.setInt(1, idOrden);
                stmt.setInt(2, item.getIdInventario());
                stmt.setInt(3, item.getCantidad());
                stmt.setDouble(4, item.getPrecioVenta());
                stmt.setDouble(5, item.getSubTotal());
                stmt.setInt(6, idMenu);
                tmp = stmt.executeUpdate();
                rows += tmp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleComplementosSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
               ConexionSql.close(stmt);
               ConexionSql.close(conn);
            }
        }
        return rows;
    }
}
