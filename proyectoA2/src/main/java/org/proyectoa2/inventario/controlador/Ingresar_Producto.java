/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.controlador;

import java.util.Date;
import org.marcos.dto.Inventario;
import static org.marcos.sql.InventarioSql.Insertar;
import org.proyectoa2.inventario.interfaces.TipoProducto;

/**
 *
 * @author Gilda
 */
public class Ingresar_Producto {

    private TipoProducto tipo;

    public void Crear(String descripcion, int existencia, String lote, Date fecha, String nombre, TipoProducto tp) {

        this.tipo = tp;
        Inventario i = new Inventario(descripcion, existencia, lote, fecha, nombre);
        i = this.tipo.tipoProducto(fecha, i);

        String g = Insertar(i);
    }
}
