/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

/**
 *
 * @author pc
 */
public class Ordenarmiento {

    public static int[] ordenarArray(int[] array) {
        // Declarar array enteros
        // Programar todo lo que haga falta para ordenaro (
        // int[] array =  { 4,2,3,1,5, 2, 2, -5};
        if (array == null || array.length <= 0) {
            return array;
        }

        int[] arrOrd = new int[array.length];
        int inicio = 0;
        int menor, posMenor;

        do {
            menor = array[inicio];   // -Integer.MAX_VALUE;
            posMenor = inicio;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < menor) {
                    menor = array[i];
                    posMenor = i;
                }
            }
            array[posMenor] = Integer.MAX_VALUE;
            arrOrd[inicio] = menor;
            inicio++;

            System.out.println("\n\nOriginal: ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println("\nMenor: " + menor);
            for (int i = 0; i < array.length; i++) {
                System.out.print(arrOrd[i] + ", ");
            }
        } while (inicio < array.length);

        return arrOrd;
    }

    public static int[] burbuja(int arreglo[]) {
        
        if (arreglo == null) return null;
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int tmp = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + "\n");
        }
        return arreglo;
    }
}
