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
public class DatosBasicos {
    
    public static void mostrarTiposDatos() {
               byte unByte = -128; 
        int unEntero = 2000000000;  // 4 bytes
        System.out.println("Byte: " + unByte);
        System.out.println("Entero: " + unEntero);
        long enteroLargo = 300000000000000L;    // 8 bytes
        System.out.println("Entero largo: " + enteroLargo);
        float unDecimal = 1.23456789f;     // 4 bytes
        // 7 ú 8 cifras decimales
        System.out.println("Float: " + unDecimal);
        float otroDecimal = 1234567890123456789f;     // 4 bytes
        System.out.println("Float grande: " + otroDecimal);
        
        double decimalDoblePrec = 1.2345678901234567890;
        // 8 bytes, aprox. 15 ó 16 cifras mantisa
        System.out.println("Double: " + decimalDoblePrec);
        boolean condicion = true;   // 1 byte
        
        char unCaracter = 'A';
        // 2 bytes por el formato unicode
        System.out.println("Caracter: " + unCaracter);
        char unCharEntero = 2001;
        System.out.println("Caracter en nº: " + (int) unCaracter);
        System.out.println("Caracter en char: " + unCharEntero);
        
        String unTexto = "Que esto es un txt";
        System.out.println("String: " + unTexto);
        System.out.println("Concatenado: " + unTexto.concat("AÑADIDO"));
        System.out.println("En mayusculas: " + unTexto.toUpperCase()); 
    }

    public static void probarOperadores() {
        // Operadores unarios:
        System.out.println("Negacion: " + ! true);
        System.out.println("Negativo: " + - (10 + 5) );
        // Conversiones explícitas
        System.out.println("Casting: " + (float) 3.3434343434343434);   
        System.out.println("Casting: " + (int) 33434343434343434L);
        int contador  /*;
        contador*/ = 10;
        System.out.println("Incremento: " + contador++);
        System.out.println("Incremento: " + ++contador);
        
        // Operadores binarios: (dos operandos)
            // Parentesis,, suma y conversión implícita
        System.out.println("Suma y division:  " + (6 + 5F) / 3 );    // 3.6666
        System.out.println("Resto div entera:  " + 11 % 3 );    // 3.6666
            // Operadores booleanos
        System.out.println("Es cierto?: " + (true && false));    // Operador AND
        System.out.println("Es cierto?: " + ((true) || false));    // Operador OR
        // Igualdad y similares:
        System.out.println("Es cierto?: " + (5 == 5 || 5 > 9));  // Operador OR
        System.out.println("Es cierto?: " + (5 != 5 && 5 <= 9)); // Operador distinto
        // Operadores bit a bit
        // 00010101  = 21       
        // 00000111  =  7
        // 00000101  =  5   AND
        // 00010111  = 23   OR
        // 00010010  = 18   XOR (Or exclusivo, como el OR, pero 1 & 1 = 0
        System.out.println("Op. binario 21 AND 7 = " + ( 21  &  7) );
        System.out.println("Op. binario 21 OR  7 = " + ( 21  |  7) );
        System.out.println("Op. binario 21 AND 7 = " + ( 21  ^  7) );
    }
    
}
