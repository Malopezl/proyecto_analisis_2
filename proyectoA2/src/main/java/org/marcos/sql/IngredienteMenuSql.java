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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.marcos.dto.IngredienteMenu;

/**
 *
 * @author marcos
 * @author sharon
 */
public class IngredienteMenuSql {
    public static void INSERTAR(IngredienteMenu ingrediente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_INSERT = "INSERT INTO IngredienteMenu(idMenu, idInventario, cantidad) VALUES(?,?,?) ";
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, ingrediente.getIdMenu());
            stmt.setInt(2, ingrediente.getIdInventario());
            stmt.setDouble(3, ingrediente.getCantidad());
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        
    }
    public static void ELIMINAR(int idMenu, int idInventario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_DELETE = "DELETE FROM IngredienteMenu WHERE idMenu = '%"+ idMenu+ "%' AND idInventario ='%"+ idInventario+ "%'";
            stmt = conn.prepareStatement(SQL_DELETE);
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
    }
    public static void ELIMINARMENU(int idMenu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_DELETE = "DELETE FROM IngredienteMenu WHERE idMenu = '%"+ idMenu+"%'";
            stmt = conn.prepareStatement(SQL_DELETE);
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
    }
    
    public static ArrayList<IngredienteMenu> LINGREDIENTES(int idMenu){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<IngredienteMenu> lista = new ArrayList<>();
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT * FROM IngredienteMenu WHERE idMenu LIKE '%" + idMenu + "%'";
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery(SQL_CONSULTA);
            IngredienteMenu ingrediente;
            while(rs.next()){
                ingrediente = new IngredienteMenu();
                ingrediente.setIdMenu(rs.getInt("idMenu"));
                ingrediente.setIdInventario(rs.getInt("idInventario"));
                ingrediente.setCantidad(rs.getDouble("cantidad"));
                lista.add(ingrediente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuSql.class.getName()).log(Level.SEVERE, null, ex);
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
