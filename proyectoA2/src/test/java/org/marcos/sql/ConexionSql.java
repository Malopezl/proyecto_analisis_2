/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.sql;
import java.sql.*;
/**
 *
 * @author marcos
 */
public class ConexionSql {
    private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/manejoCafe";
    private static final String JDBC_USER = "marcos";
    private static final String JDBC_PASS = "ms0664";
    
    public static synchronized Connection getConnection() throws SQLException{
         return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public static void close(ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement stmt){
        try{
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        } catch (SQLException sqle){
            sqle.printStackTrace(System.out);
        }
    }
    
    
}
