/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn;

import com.vn.liboperaarrays.OperarArraysDoubles;
import com.vn.liboperaarrays.OperarArraysDoubles.FunCallbackOperarArrays;
import java.io.PrintStream;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double[] array_A = {1, 2, 3, 4, 5};
        double[] array_B = {2, 3, 4, 5, 6};
        // Desde Java 8 permite las funciones callback
        double[] arraySumaAB = 
                OperarArraysDoubles.operarArrays(array_A, array_B, Main::suma);
        
        arrayEnTabla(System.out, arraySumaAB);
        FunCallbackOperarArrays divide = (double x, double y) -> {
            return x / y;
        };
        double[] arrayDivAB = 
                OperarArraysDoubles.operarArrays(array_A, array_B, divide);
        arrayEnTabla(System.out, arrayDivAB);
        
        double[] arrayRestaAB = 
                OperarArraysDoubles.operarArrays(
                        array_A, array_B, (double x, double y) -> {
                    return x - y;
                });
        arrayEnTabla(System.out, arrayRestaAB);
    }
    
    public static double suma(double x, double y) {
        return x + y;
    }
    public static void arrayEnTabla(PrintStream salida, double[] array) {
        
        String tabla = "<table border=2><tr>\n";
        for (int index = 0; index < array.length; index++) {
            final double element = array[index];
            tabla += "<td>&nbsp; " + element + " &nbsp;</td>\n";
        }
        salida.println(tabla + "</tr></table>");
    }
}
