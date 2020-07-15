/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto2a.administracion.controller;

import org.marcos.dto.Usuario;
import org.marcos.sql.UsuarioSql;

/**
 *
 * @author sharon
 */
public class ControladorUsuario {
    
    public static void CrearUsuario(Usuario usuario){
        UsuarioSql.INSERTAR(usuario);
    }
    public static void EditarUsuario(Usuario usuario){
        UsuarioSql.ACTUALIZAR(usuario);
    }
    public static void Eliminarusuario(Usuario usuario){
        UsuarioSql.ELIMINAR(usuario.getIdUsuario());
    }
}
