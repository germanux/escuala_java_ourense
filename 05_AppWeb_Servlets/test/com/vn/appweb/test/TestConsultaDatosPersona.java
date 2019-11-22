package com.vn.appweb.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.vn.appweb.modelo.ConsultaSQL;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestConsultaDatosPersona {
    
    public TestConsultaDatosPersona() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testSelectSQL() {
        ConsultaSQL conSQL = new ConsultaSQL();
        assertEquals(0, conSQL.leerTabla("No(·/$&·($()R$%ba").size());
        
        assertEquals("Nombre de Prueba", 
                conSQL.leerTabla("Nombre de Prueba").get(0).getNombre());
        
        assertEquals(2,  conSQL.leerTabla("oo").size());
        assertEquals("asdfdf2@dfdf3",  conSQL.leerTabla("oo").get(1).getEmail());
        assertEquals(5,  conSQL.leerTabla("").size());
        assertEquals("Aaaaaa Bbbbbb Ccccc",  conSQL.leerTabla("bbb").get(0).getNombre());
    }
}
