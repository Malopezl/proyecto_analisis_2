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
import org.marcos.dto.Usuario;

/**
 *
 * @author marcos
 * @author sharon
 */
public class UsuarioSql {
    public static ArrayList<Usuario> getAllUsuarios(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> lista = new ArrayList<>();
        try{
            conn = ConexionSql.getConnection();
            String selectAllPuestos = "SELECT *FROM Usuario ";
            stmt = conn.prepareStatement(selectAllPuestos);
            rs = stmt.executeQuery(selectAllPuestos);
            Usuario usuario;
            while(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setDireccion(rs.getString("direccionUsuario"));
                usuario.setCorreo(rs.getString("correoUsuario"));
                usuario.setTelefono(rs.getString("telefonoUsuario"));
                usuario.setIdPuesto(rs.getInt("Puesto_id"));
                lista.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return lista;
    }
    public static void INSERTAR(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_INSERT = "INSERT INTO Usuario(nombreUsuario, password, direccionUsuario, correoUsuario, telefonoUsuario, Puesto_id) VALUES(?,?,?,?,?,?) ";
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombreUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getDireccion());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getTelefono());
            stmt.setInt(6, usuario.getIdPuesto());
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
    }
    public static void ACTUALIZAR(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionSql.getConnection();
            String SQL_UPDATE = "UPDATE Usuario SET nombreUsuario = '"+ usuario.getNombreUsuario()+"' , password = '"+ usuario.getPassword()+"' , direccionUsuario = '"+ usuario.getDireccion()+"' , correoUsuario = '"+ usuario.getCorreo()+"' , telefonoUsuario = '"+ usuario.getTelefono()+"', Puesto_id ="+ usuario.getIdPuesto()+" WHERE idUsuario= "+usuario.getIdUsuario();
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
            String SQL_DELETE = "DELETE FROM Usuario WHERE idUsuario = "+id;
            stmt = conn.prepareStatement(SQL_DELETE);
            int rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngredienteMenuSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexionSql.close(stmt);
            ConexionSql.close(conn);
        }
    }
    public static Usuario USUARIO_LOGIN(String nombreUsuario, String pass){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(0);
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT *FROM Usuario WHERE nombreUsuario = '"+ nombreUsuario+"' AND password ='" + pass + "'";
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery();
            if(rs.next()){
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setDireccion(rs.getString("direccionUsuario"));
                usuario.setCorreo(rs.getString("correoUsuario"));
                usuario.setTelefono(rs.getString("telefonoUsuario"));
                usuario.setIdPuesto(rs.getInt("Puesto_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return usuario;
    }
    public static Usuario USUARIO_ID(int idUsuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT *FROM Usuario WHERE idUsuario = "+ idUsuario;
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery(SQL_CONSULTA);
            while(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setDireccion(rs.getString("direccionUsuario"));
                usuario.setCorreo(rs.getString("correoUsuario"));
                usuario.setTelefono(rs.getString("telefonoUsuario"));
                usuario.setIdPuesto(rs.getInt("Puesto_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return usuario;
    }
    
    public static Usuario USUARIO_CORREO(String correo){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT *FROM Usuario WHERE correoUsuario LIKE '%"+ correo +"%'";
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setDireccion(rs.getString("direccionUsuario"));
                usuario.setCorreo(rs.getString("correoUsuario"));
                usuario.setTelefono(rs.getString("telefonoUsuario"));
                usuario.setIdPuesto(rs.getInt("Puesto_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return usuario;
    }
    
    public static Usuario USUARIO_TELEFONO(String telefono){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try{
            conn = ConexionSql.getConnection();
            String SQL_CONSULTA = "SELECT *FROM Usuario WHERE telefonoUsuario LIKE '%"+ telefono +"%'";
            stmt = conn.prepareStatement(SQL_CONSULTA);
            rs = stmt.executeQuery(SQL_CONSULTA);
            while(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombreUsuario(rs.getString("nombreUsuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setDireccion(rs.getString("direccionUsuario"));
                usuario.setCorreo(rs.getString("correoUsuario"));
                usuario.setTelefono(rs.getString("telefonoUsuario"));
                usuario.setIdPuesto(rs.getInt("Puesto_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return usuario;
    }
    
    
}
