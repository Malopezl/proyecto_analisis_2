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
public class ControladorLogin {
    public static Usuario BuscarUsuario(String usuario, String pass){
        return UsuarioSql.USUARIO_LOGIN(usuario, pass);
        
        
    }
}
