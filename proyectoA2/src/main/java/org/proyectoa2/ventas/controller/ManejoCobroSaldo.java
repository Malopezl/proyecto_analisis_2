/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import org.marcos.dto.Cliente;
import org.marcos.sql.ClienteSql;

/**
 *
 * @author marcos
 */
public class ManejoCobroSaldo {
    
    public Cliente obtenerCliente(int id){
        id -= 1;
        ManejoListaClientes manejo = ManejoListaClientes.obtenerManejador();
        return manejo.getCliente(id);
    }
    public double realiarPago(Cliente cliente, double pago, double cantidadPagar){
        double nuevoSaldo =  cliente.getSaldo() - cantidadPagar;
        double cambio;
        cambio = pago - pago;
        cliente.setSaldo(nuevoSaldo);
        ClienteSql clienteSql = new ClienteSql();
        clienteSql.actualizarSaldo(cliente);
        ManejoListaClientes manejo = ManejoListaClientes.obtenerManejador();
        manejo.actualizarClientes();
        return cambio;
    }
    
}
