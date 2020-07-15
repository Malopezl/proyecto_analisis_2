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
import org.marcos.dto.Puesto;
/**
 *
 * @author marcos
 * @author sharon
 */
public class PuestoSql {
    public static ArrayList<Puesto> getAllPuestos(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Puesto> lista = new ArrayList<>();
        try{
            conn = ConexionSql.getConnection();
            String selectAllPuestos = "SELECT *FROM Puesto ";
            stmt = conn.prepareStatement(selectAllPuestos);
            rs = stmt.executeQuery();
            Puesto puesto;
            while(rs.next()){
                puesto = new Puesto();
                puesto.setId(rs.getInt("id"));
                puesto.setNombre(rs.getString("Nombre"));
                puesto.setDescripcion(rs.getString("Descripcion"));
                puesto.setRol(rs.getString("Rol"));
                lista.add(puesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PuestoSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return lista;
    }
    public static void INSERTAR(Puesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_INSERT = "INSERT INTO Puesto(Nombre, Descripcion, Rol) VALUES(?,?,?) ";
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, puesto.getNombre());
            stmt.setString(2, puesto.getDescripcion());
            stmt.setString(3, puesto.getRol());
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
    }
    public static void ACTUALIZAR(Puesto puesto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_UPDATE = "UPDATE Puesto SET Nombre = '%"+ puesto.getNombre()+"%' ,Descripcion = '%"+ puesto.getDescripcion()+"%', Rol = '%"+ puesto.getRol()+"%' WHERE id='%"+ puesto.getId()+"%'";
            stmt = conn.prepareStatement(SQL_UPDATE);
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
    }
    public static void ELIMINAR(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_DELETE = "DELETE FROM Puesto WHERE id = '%"+ id+"%'";
            stmt = conn.prepareStatement(SQL_DELETE);
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
    }
    public static Puesto PUESTO_ID(int id){
        Connection conn = null;
        PreparedStatement stmt = null;
        Puesto puesto = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_Consulta = "SELECT *FROM Puesto WHERE id = '%"+ id+"%'";
            stmt = conn.prepareStatement(SQL_Consulta);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                puesto = new Puesto();
                puesto.setId(rs.getInt("id"));
                puesto.setNombre(rs.getString("Nombre"));
                puesto.setDescripcion(rs.getString("Descripcion"));
                puesto.setRol(rs.getString("Rol"));
            }
        

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return puesto;
    }
    public static Puesto PUESTO_NOMBRE(String nombre){
        Connection conn = null;
        PreparedStatement stmt = null;
        Puesto puesto = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_Consulta = "SELECT *FROM Puesto WHERE Nombre = '%"+ nombre+"%'";
            stmt = conn.prepareStatement(SQL_Consulta);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                puesto = new Puesto();
                puesto.setId(rs.getInt("id"));
                puesto.setNombre(rs.getString("Nombre"));
                puesto.setDescripcion(rs.getString("Descripcion"));
                puesto.setRol(rs.getString("Rol"));
            }
        

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return puesto;
    }
    
    public static Puesto PUESTO_ROL(String rol){
        Connection conn = null;
        PreparedStatement stmt = null;
        Puesto puesto = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_Consulta = "SELECT *FROM Puesto WHERE Rol = '%"+ rol+"%'";
            stmt = conn.prepareStatement(SQL_Consulta);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                puesto = new Puesto();
                puesto.setId(rs.getInt("id"));
                puesto.setNombre(rs.getString("Nombre"));
                puesto.setDescripcion(rs.getString("Descripcion"));
                puesto.setRol(rs.getString("Rol"));
            }
        

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
        return puesto;
    }
    
        
    }
    
    
    
    
    
    

