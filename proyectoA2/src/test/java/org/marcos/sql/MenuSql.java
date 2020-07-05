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
 */
public class MenuSql {
    
    private String selectAllPlatillos = "SELECT idMenu, nombreMenu, descripcionMenu, precio, receta, estado FROM Menu";
    
    
    public ArrayList<Menu> getAllMenu(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Menu> lista = new ArrayList<>();
        try{
            conn = ConexionSql.getConnection();
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
}
