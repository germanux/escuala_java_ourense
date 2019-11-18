/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.liboperaarrays;

/**
 *
 * @author pc
 */

// C#: public delegate Object[] TipoFunCallbackOpera(Object[] arrX, Object[] arrY);

public class OperarArraysObject {
    
    @FunctionalInterface
    public interface FunCallbackOperarArrays {
        // Sólo podemos declar (que luego implementar) un método
        Object operar(Object x, Object y);
    }
    
    public static Object[] operarArrays(
            Object[] arrX, 
            Object[] arrY, 
            OperarArraysObject.FunCallbackOperarArrays operaCllbk)
    {
        Object[] arrayResult = null;
        if (arrX.length == arrY.length) {
            arrayResult = new Object[arrX.length];
            for (int i = 0; i < arrX.length; i++) {
                arrayResult[i] = operaCllbk.operar(arrX[i], arrY[i]);
            }
        }
        return arrayResult;
    }
}
