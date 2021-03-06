/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.ventas.controller;

import java.util.ArrayList;
import org.marcos.dto.Cliente;
import org.marcos.dto.Orden;
import org.marcos.sql.ClienteSql;
import org.marcos.sql.OrdenSql;
/**
 *
 * @author marcos
 */
public class ManejoColaOrdenes {
    private ArrayList<Orden> colaOrdenesPendientes;
    private static ManejoColaOrdenes manejo = null;
    private ArrayList<ObservadorVentas> observadores;
    private OrdenSql ordenSql;
    private ClienteSql clienteSql;
    private RealizarPago pago;
    private int indiceAtender;
    
    public Orden atenderOrden(){
        if(indiceAtender == this.colaOrdenesPendientes.size())
            return null;
        if(!(colaOrdenesPendientes.isEmpty())){
            return colaOrdenesPendientes.get(indiceAtender);
        }
        return null;
    }
    public boolean cancelarOrden(int indice){
        if(!(colaOrdenesPendientes.isEmpty())){
            colaOrdenesPendientes.remove(indice);
            this.notificar();
            return true;
        }
        return false;
    }
    public void agregarNuevaOrden(Orden orden){
        colaOrdenesPendientes.add(orden);
        this.notificar();
    }
    public double cobrarOrden(int indexCola, int tipoCobro, double cantidadPagada){
        Orden cobrar = colaOrdenesPendientes.remove(indexCola);
        ordenSql.insertNuevaOrden(cobrar);
        
        if(tipoCobro == 1){
            pago = new RealizarPagoEfectivo();
            pago.realizarPago(cobrar);
            double cambio = cantidadPagada - cobrar.getTotal();
            this.indiceAtender -= 1;
            this.notificar();
            return cambio;
        }else{
            pago = new RealizarPagoSaldo();
            pago.realizarPago(cobrar);
            this.indiceAtender -= 1;
            this.notificar();
            return 0;
        }
        
    }
    public Orden obtenerOrden(int indexCola){
        if(colaOrdenesPendientes.isEmpty()){
            return null;
        }
        return colaOrdenesPendientes.get(indexCola);
    }
    public void editarOrden( Orden orden){        
        colaOrdenesPendientes.remove(orden);
        colaOrdenesPendientes.add(orden);
        this.notificar();
    }
    public ArrayList<Orden> obtenerCola(){
        return colaOrdenesPendientes;
    }
    private ManejoColaOrdenes(){
        colaOrdenesPendientes = new ArrayList<>();
        observadores = new ArrayList<>();
        ordenSql = new OrdenSql();
        clienteSql = new ClienteSql();
        this.indiceAtender = 0;
    }
    public static ManejoColaOrdenes obtenerControlador(){
        if(manejo == null){
            manejo = new ManejoColaOrdenes();
        }
        return manejo;
    }
    public void addObservador(ObservadorVentas observer){
        observadores.add(observer);
    }
    public void eliminarObservador(ObservadorVentas observer){
        observadores.remove(observer);
    }
    public void notificar(){
        for(ObservadorVentas observer : observadores){
            observer.actualizar();
        }
    }
    public void eliminarOrden(Orden orden){
        this.colaOrdenesPendientes.remove(orden);
        this.notificar();
    }
    public void cambiarEstado(){
        this.colaOrdenesPendientes.get(indiceAtender).setEstado(2);
        this.indiceAtender+=1;
        this.notificar();
    }
}
