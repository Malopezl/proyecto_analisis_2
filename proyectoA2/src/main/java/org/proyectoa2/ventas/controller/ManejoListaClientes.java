/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import java.util.ArrayList;
import org.marcos.dto.Cliente;
import org.marcos.sql.ClienteSql;

/**
 *
 * @author marcos
 */
public class ManejoListaClientes {
    private static ManejoListaClientes manejadorClientes;
    private ArrayList<Cliente> listaClientes;
    private ClienteSql clienteSql;
    
    private ManejoListaClientes(){
        listaClientes = new ArrayList<>();
        clienteSql = new ClienteSql();
        
    }
    
    public static ManejoListaClientes obtenerManejador(){
        if(manejadorClientes == null){
            manejadorClientes = new ManejoListaClientes();
        }
        return manejadorClientes;
    }
    
    public ArrayList<Cliente> geListaClientes(){
        return listaClientes;
        
    }
    
    public void actualizarClientes(){
        if(manejadorClientes == null){
            manejadorClientes = new ManejoListaClientes();
        }
        listaClientes = clienteSql.selectAllClientes();
    }
}
