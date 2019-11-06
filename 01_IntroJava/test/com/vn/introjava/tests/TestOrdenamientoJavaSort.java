/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests;

import com.vn.introjava.funcionesbasicas.Ordenarmiento;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestOrdenamientoJavaSort {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    /** Probar Ordenamiento Sistema Humano (buscar más pequeño y meter en otro array)
     * 
     * @param array             Array que queremos ordenar
     * @param arrayOrdenadoOk   Array que sabemos que es correcto
     */
    private void probarOrdenamientoSitemaHumano(int[] array, int[] arrayOrdenadoOk) {        
        // int[] array =  { 4,2,3,1};
        // int[] arrayOrdenadoOk = {1,2,3,4};
        int[] arrayOrdPorFuncion;
        arrayOrdPorFuncion = Ordenarmiento.burbuja(array);
        assertArrayEquals(arrayOrdPorFuncion, arrayOrdenadoOk);
    }
    /**
     * Probar con array de 5 elementos
     */
    @Test
    public void probarOrdenamSistHum_Array_5() {        
        int[] array =  { 4,2,3,1 };
        int[] arrayOrdenadoOk = { 1,2,3,4 };
        probarOrdenamientoSitemaHumano(array, arrayOrdenadoOk);        
    }
    @Test
    public void probarOrdenamSistHum_Array_Invertido() {  
        probarOrdenamientoSitemaHumano(
                new int[]{ 5,4,3,2,1 }, 
                new int[]{ 1,2,3,4,5 } );
    }      
    @Test
    public void probarOrdenamSistHum_MuchosValores() {  
        probarOrdenamientoSitemaHumano(
                new int[]{ 5,4,3,2,1,6,9,7,8}, 
                new int[]{1,2,3,4,5,6,7,8,9});
    }  
    @Test
    public void probarOrdenamSistHum_Solo_Dos() {  
        probarOrdenamientoSitemaHumano(
                new int[]{ 5,4}, 
                new int[]{ 4,5});
    }  
    @Test
    public void probarOrdenamSistHum_Array_1_elemento() {  
        probarOrdenamientoSitemaHumano(
                new int[]{ 5}, 
                new int[]{ 5});
    }   
    @Test
    public void probarOrdenamSistHum_ConNegativos() {  
        probarOrdenamientoSitemaHumano(
                new int[]{ 5,4,-3,2,1,6,-9,7,8}, 
                new int[]{-9, -3,1,2,4,5,6,7,8});
    }  
    @Test
    public void probarOrdenamSistHum_ConRepetidos() {  
        probarOrdenamientoSitemaHumano(
                new int[]{ 2,4,-3,2,1,6,-9,2,8}, 
                new int[]{-9, -3,1,2,2,2,4,6,8});
    }  
    @Test
    public void probarOrdenamSistHum_ConMaximos() {  
        probarOrdenamientoSitemaHumano(
                new int[]{ 2,Integer.MAX_VALUE,-3,Integer.MAX_VALUE,1,6,-9,2,8}, 
                new int[]{-9, -3,1,2,2,6,8, Integer.MAX_VALUE,Integer.MAX_VALUE});
    }  
    @Test
    public void probarOrdenamSistHum_ConMinimos() {  
        probarOrdenamientoSitemaHumano(
                new int[]{ 2,Integer.MIN_VALUE,-3,Integer.MIN_VALUE,1,6,-9,2,8}, 
                new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE,-9, -3,1,2,2,6,8});
    } 
    @Test
    public void probarOrdenamSistHum_ConArrayVacio() {  
        probarOrdenamientoSitemaHumano(
                new int[]{}, new int[]{});
    }
    @Test
    public void probarOrdenamSistHum_ConNull() {  
        probarOrdenamientoSitemaHumano(
                null, null);
    } 
    @Test
    public void probarOrdenamSistHum_Array_Ordenado() {        
        int[] array =  { 1,2,3,4,4,5 };
        int[] arrayOrdenadoOk = { 1,2,3,4,4,5 };
        probarOrdenamientoSitemaHumano(array, arrayOrdenadoOk);        
    }
    @Test
    public void probarOrdenamientoSitemaHumano_MAL() {  
         
        //assertEquals(10, 10);
        // assertNotEquals("AA", "AA");
        //assertTrue(5.5f == 5.05f);
    }
}
