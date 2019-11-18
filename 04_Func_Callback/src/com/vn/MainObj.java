/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn;

import static com.vn.Main.arrayEnTabla;
import com.vn.liboperaarrays.OperarArraysDoubles;
import com.vn.liboperaarrays.OperarArraysObject;
import java.io.PrintStream;

/**
 *
 * @author pc
 */
public class MainObj {
    
    public static Object suma(Object x, Object y) {
        return (Double) x + (Double) y;
    }
    public static Object hacerPunto(Object x, Object y) {
        return "( " + x + " , " + y + " )";
    }
    public static void main(String[] args) {
        
        Double[] array_A = new Double[] {1.0, 2.0, 3.0, 4.0, new Double(5)};
        Double[] array_B = { 2.0, 3., 4., 5., 6.};
        // Desde Java 8 permite las funciones callback
        Object[] arraySumaAB = 
                OperarArraysObject.operarArrays(array_A, array_B, MainObj::suma);
        
        arrayEnTabla(System.out, arraySumaAB);
        OperarArraysObject.FunCallbackOperarArrays divide = (Object x, Object y) -> {
            return (Double) x / (Double) y;
        };
        Object[] arrayDivideAB = 
                OperarArraysObject.operarArrays(array_A, array_B, divide);
        arrayEnTabla(System.out, arrayDivideAB);
        
        Object[] arrayPuntosAB = 
                OperarArraysObject.operarArrays(array_A, array_B, MainObj::hacerPunto);
        arrayEnTabla(System.out, arrayPuntosAB);
    }
    public static void arrayEnTabla(PrintStream salida, Object[] array) {
        
        String tabla = "<table border=2><tr>\n";
        for (int index = 0; index < array.length; index++) {
            final Object element = array[index];
            tabla += "<td>&nbsp; " + element + " &nbsp;</td>\n";
        }
        salida.println(tabla + "</tr></table>");
    }
}
