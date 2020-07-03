/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.marcos.dto;

/**
 *
 * @author marcos
 */
public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String direccion;
    private String correo;
    private String telefono;
    private double saldo;

    public Cliente() {
    }

    public Cliente(String nombreCliente, String direccion, String correo, String telefono, double saldo) {
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.saldo = saldo;
    }
    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", saldo=" + saldo + '}';
    }
    
    
}
