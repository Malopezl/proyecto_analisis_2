/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoa2.inventario.controlador.listar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.marcos.dto.Inventario;
import static org.marcos.sql.InventarioSql.LGENERAL;
import org.proyectoa2.inventario.controlador.Tabla;
import org.proyectoa2.inventario.interfaces.Opcion;

/**
 *
 * @author Gilda
 */
public class Revision_general implements Opcion {

    @Override
    public DefaultTableModel Crear(Inventario inventario) {
        DefaultTableModel modelo = new DefaultTableModel();
        Tabla tabla = new Tabla();
        modelo = tabla.getModelo();
        ResultSet rs = LGENERAL();
        try {
            while (rs.next()) {
                // Se crea un array que será una de las filas de la tabla.
                Object[] fila = new Object[6]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Revision_general.class.getName()).log(Level.SEVERE, null, ex);
        }
        return modelo;
    }


}
