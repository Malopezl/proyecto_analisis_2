/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.controller.listar;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.marcos.dto.Inventario;
import org.marcos.sql.InventarioSql;

/**
 *
 * @author sharon
 */
public class listarIngredientes {
    public static ArrayList<Inventario> listarInventario() throws SQLException {
    ResultSet rs = InventarioSql.LGENERAL();
    ArrayList <Inventario> lista = new ArrayList<>();
    while(rs.next()){
        Inventario inventario = new Inventario();
        inventario.setIdInventario(rs.getInt("idInventario"));
        inventario.setNombre(rs.getString("nombre"));
        inventario.setDimension(rs.getString("dimension"));
        lista.add(inventario);
    }
    return lista;
    
    }
}
