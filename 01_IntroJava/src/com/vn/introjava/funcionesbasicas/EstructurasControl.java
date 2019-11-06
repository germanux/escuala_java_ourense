/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.funcionesbasicas;

/**
 *
 * @author pc
 */
public class EstructurasControl {
    public static void ejecutarBucles() {
        char arrayChar[] = {'a', 'B', '8', '*'};
        int index = 0;
        while (index < arrayChar.length) {
            System.out.println("Index = " + index + ", char= " + arrayChar[index]);
            index++; // index += 1; index = index + 1; 
        }
        for ( index = 0/* ini */; index < arrayChar.length/* cond */ ; ++index /* inc */ ) 
            System.out.println("Index = " + index + ", char= " + arrayChar[index]);
        
        index = 0;
        do {
            System.out.println("Index = " + index + ", char= " + arrayChar[index]);
            index++;
        } while(index < arrayChar.length);        
        
        for (char caracter : arrayChar) {
            System.out.println("char = " + caracter);
        }
    }
    
    public static void ejecutarCondiciones() {
        if ("Palabra".length() > 5) {       // Condicional simple
            System.out.println("Palabra larga");
        }
        // Condicionales compuestos
        if ("Texto".length() > 5) 
            
            System.out.println("// Por aquí no entra");
         else 
            System.out.println("Palabra corta");
        
        
        if ("En un lugar de la mancha...".contains("lugar")) {
            // No entra por aquí
            System.out.println("Tiene LUGAR");      
        } 
        else if ("En un lugar de la mancha...".contains("MANCHA")) {
            // No entra por aquí
        } else if ("En un lugar de la mancha...".contains("OTRO"))
            // No entra por aquí
            System.out.println("Tiene OTRO");
        else {
            System.out.println("No tiene ninguno porque estan en mayusculas");
        }
        
        // SWITCH
        
        int numeroPeq = 0;
        switch (numeroPeq + 5 - 5) {
            case 0: 
                System.out.println("Num peq vale cero.");
                break;
            case 1:
                System.out.println("Num peq vale uno.");
                break;
            case 2:
            case 3:
            case 4:
                if (numeroPeq == 2)
                    System.out.println("Num peq vale dos");
                else 
                    System.out.println("Num peq vale  o cuatro.");                            
                break;
            default:
                System.out.println("Es otro número (< 0    o   > 4)");
                break;
        }
//        if (numeroPeq + 5 - 5 == 0) {
//            // ...
//        } else if  (numeroPeq + 5 - 5 == 1) {
//            // ...
//        } else if  (numeroPeq + 5 - 5 == 2      ||  numeroPeq + 5 - 5 == 3    ||  numeroPeq + 5 - 5 == 4   ) {
//            
//        } else {
//            // valor por defecto
//        }
    }
 
}
