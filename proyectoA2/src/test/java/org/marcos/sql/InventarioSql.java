/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.marcos.dto.Inventario;

/**
 *
 * @author marcos 
 * @author Gilda
 */
public class InventarioSql {

    public static String Insertar(Inventario inventario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_INSERT = "INSERT INTO Inventario(descripcionInventario, existencia, lote, fechaCaducidad, nombre) VALUES(?,?,?,?,?) ";
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, inventario.getDescripcionInventario());
            stmt.setInt(2, inventario.getExistencia());
            stmt.setString(3, inventario.getLote());
            java.sql.Date sqlDate = new java.sql.Date(inventario.getFechaCaducidad().getTime());
            stmt.setDate(4, sqlDate);
            stmt.setString(5, inventario.getNombre());
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return ("");
    }

    
    public static String ELIMINAR(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_DELETE = "DELETE FROM INVENTARIO WHERE idInventario = " + id;
            stmt = conn.prepareStatement(SQL_DELETE);
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return ("");
    }

    public static ResultSet LGENERAL() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionSql.getConnection();
            String selectSQL = "select * from inventario";
            stmt = conn.prepareStatement(selectSQL);
            rs = stmt.executeQuery(selectSQL);

        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return (rs);
    }

    public static ResultSet LNOMBRE(String nombre) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionSql.getConnection();
            String selectSQL = "select * from inventario where nombre LIKE '%" + nombre + "%'";
            stmt = conn.prepareStatement(selectSQL);
            rs = stmt.executeQuery(selectSQL);

        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return (rs);
    }

    public static ResultSet LFECHA(String fecha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionSql.getConnection();
            String selectSQL = "select * from inventario where fechaCaducidad LIKE '%" + fecha + "%'";
            stmt = conn.prepareStatement(selectSQL);
            rs = stmt.executeQuery(selectSQL);

        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return (rs);
    }

    public static ResultSet LEXISTENCIA(int existencia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionSql.getConnection();
            String selectSQL = "select * from inventario where existencia LIKE '%" + existencia + "%'";
            stmt = conn.prepareStatement(selectSQL);
            rs = stmt.executeQuery(selectSQL);

        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return (rs);
    }
}
