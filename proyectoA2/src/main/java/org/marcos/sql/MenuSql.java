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
import org.marcos.dto.Menu;
/**
 *
 * @author marcos
 * @author sharon
 */
public class MenuSql {
    
    public static ArrayList<Menu> getAllMenu(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Menu> lista = new ArrayList<>();
        try{
            conn = ConexionSql.getConnection();
            String selectAllPlatillos = "SELECT idMenu, nombreMenu, descripcionMenu, precio, receta, estado FROM Menu";
            stmt = conn.prepareStatement(selectAllPlatillos);
            rs = stmt.executeQuery();
            Menu menu;
            while(rs.next()){
                menu = new Menu();
                menu.setIdMenu(rs.getInt(1));
                menu.setNombreMenu(rs.getString(2));
                menu.setDescripcionMenu(rs.getString(3));
                menu.setPrecio(rs.getDouble(4));
                menu.setReceta(rs.getString(5));
                menu.setEstado(rs.getString(6));
                lista.add(menu);
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
    
     public static int Insertar(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id=0;
        try {
            conn = ConexionSql.getConnection();
            String SQL_INSERT = "INSERT INTO Menu(nombreMenu, descripcionMenu, precio, receta, estado) VALUES(?,?,?,?,?) ";
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, menu.getNombreMenu());
            stmt.setString(2, menu.getDescripcionMenu());
            stmt.setDouble(3, menu.getPrecio());
            stmt.setString(4, menu.getReceta());
            stmt.setString(5, menu.getEstado());
            int rows = stmt.executeUpdate();
            
            String SQL_LAST_ID = "SELECT LAST_INSERT_ID() ";
            stmt = conn.prepareStatement(SQL_LAST_ID);
            rs = stmt.executeQuery(SQL_LAST_ID);
            if(rs.next()){
            id = rs.getInt("LAST_INSERT_ID()");
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return id;
     }
     
     public static void ACTUALIZAR(Menu menu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_UPDATE = "UPDATE Menu SET nombreMenu = '%"+ menu.getNombreMenu()+"%' ,descripcionMenu = '%"+ menu.getDescripcionMenu()+"%', precio = '%"+ menu.getPrecio()+"%', receta = '%"+ menu.getReceta()+"%', estado = '%"+ menu.getEstado()+"%' WHERE idMenu="+ menu.getIdMenu();
            stmt = conn.prepareStatement(SQL_UPDATE);
            int rows = stmt.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
     }
     public static void ELIMINAR(int idMenu) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_DELETE = "DELETE FROM Menu WHERE idMenu = "+ idMenu;
            stmt = conn.prepareStatement(SQL_DELETE);
            int rows = stmt.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(InventarioSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
     }
     
     public static Menu MENU_ID(int idMenu){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Menu menu = new Menu();
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT * FROM Menu WHERE idMenu ="+ idMenu;
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery();
            while(rs.next()){
                menu.setIdMenu(rs.getInt(1));
                menu.setNombreMenu(rs.getString(2));
                menu.setDescripcionMenu(rs.getString(3));
                menu.setPrecio(rs.getDouble(4));
                menu.setReceta(rs.getString(5));
                menu.setEstado(rs.getString(6));
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
        return menu;
    }
     public static ArrayList<Menu> MENU_NOMBRE(String nombre){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Menu> lista = new ArrayList<>();
        
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT * FROM Menu WHERE nombreMenu LIKE '%"+nombre+"%'";
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery();
            Menu menu;
            while(rs.next()){
                menu = new Menu();
                menu.setIdMenu(rs.getInt(1));
                menu.setNombreMenu(rs.getString(2));
                menu.setDescripcionMenu(rs.getString(3));
                menu.setPrecio(rs.getDouble(4));
                menu.setReceta(rs.getString(5));
                menu.setEstado(rs.getString(6));
                lista.add(menu);
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
     public static ArrayList<Menu> MENU_PRECIO(Double precio){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Menu> lista = new ArrayList<>();
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT * FROM Menu WHERE precio ="+ precio;
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery();
            Menu menu;
            while(rs.next()){
                menu = new Menu();
                menu.setIdMenu(rs.getInt(1));
                menu.setNombreMenu(rs.getString(2));
                menu.setDescripcionMenu(rs.getString(3));
                menu.setPrecio(rs.getDouble(4));
                menu.setReceta(rs.getString(5));
                menu.setEstado(rs.getString(6));
                lista.add(menu);
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
     
     public static ArrayList<Menu> MENU_ESTADO(String estado){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Menu> lista = new ArrayList<>();
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT * FROM Menu WHERE estado LIKE '%"+ estado +"%'";
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery();
            Menu menu;
            while(rs.next()){
                menu = new Menu();
                menu.setIdMenu(rs.getInt(1));
                menu.setNombreMenu(rs.getString(2));
                menu.setDescripcionMenu(rs.getString(3));
                menu.setPrecio(rs.getDouble(4));
                menu.setReceta(rs.getString(5));
                menu.setEstado(rs.getString(6));
                lista.add(menu);
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