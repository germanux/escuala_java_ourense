/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoCocheList;
import com.vn.introjava.dao.DaoCocheMap;
import com.vn.introjava.dao.DaoUsuarioList;
import com.vn.introjava.dao.IDaoCoche;
import com.vn.introjava.dao.IDaoUsuario;
import com.vn.introjava.dao.Usuario;
import com.vn.introjava.poo.vehiculos.Coche;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoCocheSimple {
    
    @Test
    public void testDaoCocheList() throws Exception {
        testInterfaceDaoCoche(new DaoCocheList());
    }
    @Test
    public void testDaoCocheMap() throws Exception {
        testInterfaceDaoCoche(new DaoCocheMap());
    }
    void testInterfaceDaoCoche (IDaoCoche daoCoche) throws Exception{
        daoCoche.crear("Coche A");
        daoCoche.crear("Coche B");
        Coche cc = daoCoche.crear("Coche C");
        /* daoCoche.crear(cc);
        daoCoche.crear(cc); */
        
        assertEquals("Coche B", daoCoche.obtenerPorIndice(1).getMarca());
        assertEquals("Coche C", daoCoche.obtenerPorMarca("Coche C").getMarca());
        assertEquals("Coche C", daoCoche.obtenerPorIndice(2).getMarca());
        
        Coche modificar = new Coche("Coche B ahora X");      
        daoCoche.modificar(1, modificar);
        assertEquals("Coche B ahora X", daoCoche.obtenerPorIndice(1).getMarca());
        
        modificar = new Coche("Coche C");
        modificar.arrancar();
        daoCoche.modificar(2, modificar);   // El nº 2 es cc, debe ser arrancado aquí dentro
        assertEquals(modificar.isArrancado(), cc.isArrancado());        
        
        daoCoche.eliminar(1);   // Eliminar el B
        // daoCoche.eliminar(daoCoche.obtenerPorMarca("Coche A")); // El A, queda el C
        daoCoche.eliminar(new Coche("Coche A"));
        
        assertNull(daoCoche.obtenerPorIndice(1));
        
        assertNull(daoCoche.obtenerPorMarca("Coche A"));
        
        if (daoCoche instanceof DaoCocheList) {
            assertEquals("Coche C", daoCoche.obtenerPorIndice(0).getMarca());  // EL índice baja
        } else {
            assertEquals("Coche C", daoCoche.obtenerPorIndice(2).getMarca());  // EL índice no cambia
        }
    }
    
    @Test
    public void testUsuarioDaoList() throws Exception {
        IDaoUsuario daoUsuario= new DaoUsuarioList();
        testUsuarioDao(daoUsuario);
    }
    public void testUsuarioDao(IDaoUsuario daoUsuario) throws Exception {
        daoUsuario.crear(new Usuario("Juan", 30));
        daoUsuario.crear(new Usuario("Ana", 31));
        daoUsuario.crear(new Usuario("Bea", 32));
        daoUsuario.crear(new Usuario("Luis", 29));
        assertEquals("Ana", daoUsuario.obtenerPorIndice(1).getNombre());
        assertEquals(32, daoUsuario.obtenerPorNombre("Bea").getEdad());
        
        daoUsuario.modificar(1, new Usuario("Ana Modif", 21));
        assertEquals("Ana Modif", daoUsuario.obtenerPorIndice(1).getNombre());
        assertEquals(21, daoUsuario.obtenerPorIndice(1).getEdad());
        
        daoUsuario.eliminar(daoUsuario.obtenerPorIndice(0));
        daoUsuario.eliminar(1); // El 1 ahora es Bea
        // EL 1 ahora es Luis
        assertEquals("Luis", daoUsuario.obtenerPorIndice(1).getNombre());
    }
}
