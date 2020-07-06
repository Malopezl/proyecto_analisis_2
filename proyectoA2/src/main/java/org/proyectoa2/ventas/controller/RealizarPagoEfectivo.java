/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import org.marcos.dto.Cliente;
import org.marcos.dto.Orden;
import org.marcos.sql.ClienteSql;

/**
 *
 * @author marcos
 */
public class RealizarPagoEfectivo extends RealizarPago{

    @Override
    public void realizarPago(Orden cobrar) {
        Cliente cliente = cobrar.getCliente();
            double nuevoSaldo = cobrar.getTotal() + cliente.getSaldo();
            cliente.setSaldo(nuevoSaldo);
            ClienteSql clienteSql = new ClienteSql();
            clienteSql.actualizarSaldo(cliente);
            /*
                agregar actualizar lista clientes
            */ 
            super.generarFactura();
    }
    
}
