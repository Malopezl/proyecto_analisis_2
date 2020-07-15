/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.sql;

import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class pruebas {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?,?,?,?) ";
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, "Carolina");
            stmt.setString(2, "cahvez");
            stmt.setString(3, "CChavez@mail.com");
            stmt.setString(4, "11223344");
            int rows = stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        
    }
}
