/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.proyectoa2.compras.controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Compra;
import org.marcos.dto.DetalleCompra;
import org.marcos.sql.DetalleCompraSql;

/**
 * 
 * @author marvin <lopez.marvin9 at gmail.com>
 */
public class ManejoDetalleCompra {
    private static ManejoDetalleCompra manejadorDetalle;
    private final ArrayList<DetalleCompra> listaDetalle;
    private final DetalleCompraSql detallesql;

    public ManejoDetalleCompra() {
        listaDetalle = new ArrayList<>();
        detallesql = new DetalleCompraSql();
    }
     
    public static ManejoDetalleCompra obtenerDetalles() {
        if(manejadorDetalle == null){
            manejadorDetalle = new ManejoDetalleCompra();
        }
        return manejadorDetalle;
    }
    
    public ArrayList<DetalleCompra> getListaDetalles(){
        return listaDetalle;
        
    }
    
    public void actualizarDetalle(String factura){
        if(manejadorDetalle == null){
            manejadorDetalle = new ManejoDetalleCompra();
        }
    }
    
    public DetalleCompra getDetalleCompra(int index){
        return this.listaDetalle.get(index);
    }
    
    public Compra listarDatos(String factura) {
        return detallesql.obtenerDetalle(factura);
    }
    
    public DefaultTableModel listarDetalle(DefaultTableModel modelo, int id) {
        DefaultTableModel model = modelo;
        ResultSet rs = detallesql.seleccionarDetalle(id);

        try {
            while (rs.next()) {
                Object[] fila = new Object[4];
                
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejoDetalleCompra.class.getName()).log(Level.SEVERE, null, ex);
        }

        return model;
    }
}
