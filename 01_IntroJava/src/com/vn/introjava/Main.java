/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import static com.vn.introjava.funcionesbasicas.DatosBasicos.*;
import com.vn.introjava.poo.Coche;
import com.vn.introjava.poo.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal del proyecto Ejemplos java
 *
 * @author pc
 */
public class Main {

    /**
     * Función que se ejectua al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        mostrarTiposDatos();
//        EstructurasControl.ejecutarBucles();
//        EstructurasControl.ejecutarCondiciones();        
//        probarOperadores();
// Ordenarmiento.ordenarArray();
// Ordenarmiento.burbuja(null )

        try {
            System.out.println("Tipos de datos");

            Coche c = FabricaCoches.crear("Seat en main");
            c.mostrarEstado();
            c = FabricaCoches.crear(null);
            c.mostrarEstado();
        } catch (Exception ex) {
            System.err.println(">> LOG: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
