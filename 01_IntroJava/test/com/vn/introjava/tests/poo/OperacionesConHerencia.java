/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.Coche;
import com.vn.introjava.poo.CocheRally;
import com.vn.introjava.poo.TipoVehiculo;
import com.vn.introjava.poo.Tractor;
import com.vn.introjava.poo.Vehiculo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class OperacionesConHerencia {
    
    static Coche turismo;
    static CocheRally supra;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        supra = new CocheRally();
        supra.setMarca("Toyota");
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testSobreescrituraMetodos() throws Exception
    {
        supra.setRozamiento(7f);
        assertTrue(supra.getRozamiento() == 7f);
        // Usando T.D.D.
        assertTrue(supra.arrancar("arrancar"));
        assertTrue(supra.arrancar("ARRANcar"));
        assertTrue(supra.arrancar("Encender"));
        supra.mostrarEstado();
    }
    
    @Test
    public void testPolimorfismo() {
        supra.setRozamiento(15f);
        
        turismo = supra;
        // turismo.setRozamiento(15f);
        // EN Java todos los métodos virtuales
        // Si un hijo tiene un método, se invoca al del hijo
        turismo.mostrarEstado();
    }
    
    @Test 
    public void testEnumerado() {
        supra.setTipo(TipoVehiculo.RALLY);
        // Un enumerado es un int, limitado a lista de valores indicados
        System.out.println(" Tipo: " + supra.getTipo().toString());
        System.out.println(" Valor tipo: " + supra.getTipo().ordinal());
         
        
        Tractor miTractorAmarillo = new  Tractor();
        miTractorAmarillo.setTipo(TipoVehiculo.values()[2]);
        System.out.println(" Tipo desde int: " 
                + miTractorAmarillo.getTipo());  
                
        miTractorAmarillo.setTipo(TipoVehiculo.valueOf("TRACTOR"));
        System.out.println(" Tipo desde String: " 
                + miTractorAmarillo.getTipo());
    }
    
    @Test 
    public void testClasesAbstractas() {
        //  Vehiculo vehDesc = new Vehiculo(); // No se puede
        Vehiculo vehDesc = new Coche("Dacia");
        Vehiculo subaru = new CocheRally("Subaru");
        Vehiculo miTrac = new Tractor();
        vehDesc.avanzar();
        miTrac.avanzar();
        // Mediante un casting explícito podemos invocar a sus métodos
        assertEquals( ( (CocheRally) subaru).getMarca() , "Subaru");
        
        Vehiculo[] misVehiculos = new Vehiculo[] {
            vehDesc,
            miTrac,
            new Coche("Electrico"),
            subaru,
        };
        System.out.println("*** LISTA DE VEHICULOS " +  misVehiculos.length + " VEHICULOS");
        for (Vehiculo miVehiculo : misVehiculos) {
            System.out.println(" - " + miVehiculo.getTipo());
            miVehiculo.avanzar();
            miVehiculo.mostrarEstado();
        }
        System.out.println("*** FIN LISTA ***");
    }
}
