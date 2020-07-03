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
public class Usuario {
    public int idUsuario;
    public String nombreUsuario;
    public String password;
    public String direccion;
    public String correo;
    public String telefono;
    public Puesto puesto;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password, String direccion, String correo, String telefono, Puesto puesto) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.puesto = puesto;
    }
    
    

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", puesto=" + puesto + '}';
    }
    
    
    
}
