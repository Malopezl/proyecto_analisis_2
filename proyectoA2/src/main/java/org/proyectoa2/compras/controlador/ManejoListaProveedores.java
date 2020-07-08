/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.compras.controlador;

import java.util.ArrayList;
import org.marcos.dto.Proveedor;
import org.marcos.sql.ProveedorSql;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class ManejoListaProveedores {
    private static ManejoListaProveedores manejadorProveedor;
    private ArrayList<Proveedor> listaProveedores;
    private final ProveedorSql proveedorsql;

    public ManejoListaProveedores() {
        listaProveedores = new ArrayList<>();
        proveedorsql = new ProveedorSql();
    }
    
    public static ManejoListaProveedores obtenerProveedores() {
        if(manejadorProveedor == null){
            manejadorProveedor = new ManejoListaProveedores();
        }
        return manejadorProveedor;
    }
    
    public ArrayList<Proveedor> getListaProveedores(){
        return listaProveedores;
        
    }
    
    public void actualizarProveedores(){
        if(manejadorProveedor == null){
            manejadorProveedor = new ManejoListaProveedores();
        }
        listaProveedores = proveedorsql.seleccionarProveedores();
    }
    
    public Proveedor getProveedor(int index){
        return this.listaProveedores.get(index);
    }
}
