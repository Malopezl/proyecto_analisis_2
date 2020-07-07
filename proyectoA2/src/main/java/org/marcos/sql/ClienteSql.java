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
import org.marcos.dto.Cliente;
/**
 *
 * @author marcos
 */
public class ClienteSql {
    
    private final String setenciaSelectAll = "SELECT idCliente, nombreCliente, direccionCliente, correoCliente, telefonoCliente, saldo FROM Cliente";
    private final String sentenciaActualizarSaldo = "UPDATE Cliente SET saldo=? WHERE idCliente=?";
    private final String sentenciaInserVentas = "INSERT INTO Cliente(nombreCliente, direccionCliente, correoCliente, telefonoCliente, saldo) VALUES(?, ?, ?, ?. ?)";
    
    public ArrayList<Cliente> selectAllClientes(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> lista = new ArrayList<>();
        try{
            conn = ConexionSql.getConnection();
            stmt = conn.prepareStatement(setenciaSelectAll);
            rs = stmt.executeQuery();
            Cliente tmp;
            while(rs.next()){
                tmp = new Cliente();
                tmp.setIdCliente(rs.getInt(1));
                tmp.setNombreCliente(rs.getString(2));
                tmp.setDireccion(rs.getString(3));
                tmp.setCorreo(rs.getString(4));
                tmp.setTelefono(rs.getString(5));
                tmp.setSaldo(rs.getDouble(6));
                lista.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(rs);
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return lista;
    }
    
    public int actualizarSaldo(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try{
            conn = ConexionSql.getConnection();
            stmt = conn.prepareStatement(sentenciaActualizarSaldo);
            stmt.setDouble(1, cliente.getSaldo());
            stmt.setInt(2, cliente.getIdCliente());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(conn);
            }
        }
        return rows;
    }
    public Cliente insertarClienteVentas(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int rows = 0;
        try{
            conn = ConexionSql.getConnection();
            stmt = conn.prepareStatement(sentenciaInserVentas);
            stmt.setString(1, cliente.getNombreCliente());
            stmt.setString(2, cliente.getDireccion());
            stmt.setString(3, cliente.getCorreo());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            rows = stmt.executeUpdate();
            String sentencia = "SELECT idCliente FROM Cliente where nombreCliente = ? AND direccionCliente = ? AND correoCliente =? AND telefonoCliente = ? ";
            
            stmt = conn.prepareStatement(sentencia);
            stmt.setString(1, cliente.getNombreCliente());
            stmt.setString(2, cliente.getDireccion());
            stmt.setString(3, cliente.getCorreo());
            stmt.setString(4, cliente.getTelefono());
            rs = stmt.executeQuery();
            cliente.setIdCliente(rs.getInt("idCliente"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteSql.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                ConexionSql.close(stmt);
                ConexionSql.close(rs);
                ConexionSql.close(conn);
            }
        }
        return cliente;
    }
}
