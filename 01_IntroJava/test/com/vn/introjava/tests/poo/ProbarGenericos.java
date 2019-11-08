/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
//import static org.junit.Assert;

/**
 *
 * @author pc
 */
public class ProbarGenericos {
    
//    @Test
//    public void testearMetodosNOGenericos() {
////        ArrayList<Integer> listIn = new ArrayList<Integer>();
////        int tres = 3, cinco = 5;
////        // insertarIntegerDuplicado(listIn, tres);
////        // insertarIntegerDuplicado(listIn, cinco);
////        for (Integer integer : listIn) {
////            System.out.println(" - " + integer);
////        }
////        ArrayList<String> listStr = new ArrayList<>();
//////        insertarIntegerDuplicado(listStr, "tres");
//////        insertarIntegerDuplicado(listStr, "cinco");
////        for (String unString : listStr) {
////            System.out.println("** " + unString);
////        }
//    }
    @Test
    public void testearClaseAnidada() {
        // Las clases anidadas generan su propio fichero bytecodes
        ProbarClaseInterfazGenericaYAnidadas.ClasePequePos c;
        c = new ProbarClaseInterfazGenericaYAnidadas.ClasePequePos(1f, 2f);
    }
    @Test
    public void testearMetodosGenericos() {
        ArrayList<Integer> listIn = new ArrayList<Integer>();
        int tres = 3, cinco = 5;
        insertarDuplicado(listIn, tres);
        insertarDuplicado(listIn, cinco);
        System.out.println("Tres sigue siendo " + tres);
        for (Integer integer : listIn) {
            System.out.println(" - " + integer);
        }
        // Inferir: Infiere, deduce el tipo por su declaración
        ArrayList<String> listStr = new ArrayList<>();
        insertarDuplicado(listStr, "tres");
        insertarDuplicado(listStr, "cinco");
        for (String unString : listStr) {
            System.out.println("** " + unString);
        }
        
        ArrayList<Coche> listaCoches = new ArrayList<Coche>();
        insertarDuplicado(listaCoches, new Coche("Coche 3"));
        insertarDuplicado(listaCoches, new Coche("Coche 5"));
        for (Coche unCoche : listaCoches) {
            System.out.println(">> " + unCoche);
        }
        Integer ultInt =  mostrarYdevolverUltimo(listIn);
        String ultStr =  mostrarYdevolverUltimo(listStr);
        Coche ultCoche =  mostrarYdevolverUltimo(listaCoches);
        assertEquals((int)ultInt, 5);
        assertEquals(ultInt, (Integer) 5);
        // assertEquals(ultInt, "5");
        assertEquals(ultStr, "cinco");
        assertEquals(ultCoche.getMarca(), "Coche 5");
    }
    // Entre < y > ponemos el nombre del tipo genérico. 
    // Esto convierte el método en un "MÉTODO GENÉRICO"
    static  <Tipo>   void insertarDuplicado(ArrayList<Tipo> listaGenerica, Tipo objeto) {
        listaGenerica.add(objeto);
        listaGenerica.add(objeto);
        System.out.println(objeto + " añadido dos veces");
        // Esto no afecta fuera del método
        if (objeto instanceof Integer) {
            Integer i = (Integer) objeto;   // Conversión explícita
            i = i + 2;
        }
        listaGenerica = null;
    }
    // Método genérico que reciba un ArrayList<Tipo>, que lo muestre (foreach) y devuelva el último valor
    static <T>  T  mostrarYdevolverUltimo(ArrayList<T> lista) {
        for (T infusion : lista) {
            System.out.println(" # " + infusion.toString());
        }
        if (lista.size() > 0)
            return lista.get(lista.size() - 1);
        else 
            return null;
    }
    
   /*   Métodos NO genéricos:
    
    static void insertarIntegerDuplicado(ArrayList<Integer> listaInt, int i) {
        listaInt.add(i);
        listaInt.add(i);
        System.out.println(i + " añadido dos veces");
        // Esto no afecta fuera del método
        i = i + 10;
        listaInt = null;
    }
    
    static void insertarIntegerDuplicado(ArrayList<String> listaString, String str) {
        listaString.add(str);
        listaString.add(str);
        System.out.println(str + " añadido dos veces");
        // Esto no afecta fuera del método
        str = str + "10";
        listaString = null;
    } */
}
