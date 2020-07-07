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
import org.marcos.dto.DetalleCompra;

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
        int indice = 1;
        
        try {
            conn = ConexionSql.getConnection();
            for (DetalleCompra detalle : lista) {
                stmt = conn.prepareStatement(sentenciaInsertar);
                stmt.setInt(indice++, idCompra);
                stmt.setInt(indice++, detalle.getIdInventario());
                stmt.setFloat(indice++, detalle.getCantidad());
                stmt.setDouble(indice++, detalle.getSubtotal());
                stmt.setDouble(indice, detalle.getPrecio());
                indice = 1;
                tmp = stmt.executeUpdate();
                rows = tmp + rows;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DetalleOrdenSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }
    
    public static ResultSet mostrar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            conn = ConexionSql.getConnection();
            String sentenciaBuscar = "SELECT c.no_factura, p.nombre, c.fecha, c.total, c.estado, dc.precio, dc.cantidad, dc.subtotal, i.nombre FROM Proveedores p INNER JOIN Compra c "
                      + "ON p.idProveedor = c.idProveedor INNER JOIN detalleCompra dc ON c.idCompra = dc.idCompra INNER JOIN Inventario i on dc.idInventario = i.idInventario";
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
