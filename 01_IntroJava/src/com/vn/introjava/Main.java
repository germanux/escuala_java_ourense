/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.vn.introjava.excepciones.UsoNormalExcepciones;
import static com.vn.introjava.funcionesbasicas.DatosBasicos.*;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.dsig.TransformException;

/**
 * Clase principal del proyecto Ejemplos java
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {
        
        // System.out.println("Hola qué pasa\u0000¿Se muestra?");
        
        /* Error no capturado, se detiene el programa
        while (args.length > -1)
            ((Object)  null).equals(args); */
        
        try {
            // Primer código con error
            System.out.println("Tipos de datos");

            Coche c = FabricaCoches.crear("Seat en main");
            c.mostrarEstado();
            // return;
            // c = FabricaCoches.crear(null); // IllegalArgumentException
            c = FabricaCoches.crear("Un coche");
            c.mostrarEstado();
            
            // Segundo código con error
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            // unObj.metodoPeligroso(); // RuntimeException
            
            throw new TransformException("Optimus Prime se ha ha quedado sin batería.");
            
            // Tercer código con error, NullPointerException
            // Object objNulo = null;
            // System.out.println("Fallará: " + objNulo.toString()); /**/
        }  // Se pueden anidar los catch
         catch (IllegalArgumentException ex) {    
            // Captura cualquier IllegalArgumentException
            System.out.println("ARGUMENTO INVÁLIDO. DECIRLE AL USUARIO LO QUÉ: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
         catch (RuntimeException ex) {    
            // Captura cualquier RuntimeException ó CUALQUIERA de sus clases hijas
            System.out.println("Cualquier tipo de RuntimeException: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {    
            // Captura cualquier Excepcion que no haya sido gestionada
            System.out.println("Cualquier tipo de Exception: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally { // Siempre se ejecuta
            // Incluso antes que un return ;
            System.out.println(">>> FIN DEL TRY - CATCH");
        }
        System.out.println("**** FIN DEL PROGRAMA");
    }
    /**
     * Función que se ejectua al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void mainTryCatchPorSeparado(String[] args) {
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
        try {
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            unObj.metodoPeligroso();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Excepcion " + ex.toString());
            System.out.println("Excepcion " + ex.getMessage());
            
            System.out.println("\nPila de llamadas "
                        + Arrays.toString(ex.getStackTrace()));
        }
        try {
            Object objNulo = null;
            System.out.println("Fallará: " + objNulo.toString());
        } catch (NullPointerException ex) {
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
