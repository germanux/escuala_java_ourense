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
        daoCoche.crear("Coche C");
        assertEquals(daoCoche.obtenerPorIndice(1).getMarca(), "Coche B");
        assertEquals(daoCoche.obtenerPorMarca("Coche C").getMarca(), "Coche C");
        assertEquals(daoCoche.obtenerPorIndice(2).getMarca(), "Coche C");
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
        assertEquals("Ana", daoUsuario.obtenerPorIndice(1).getNombre());
        assertEquals(32, daoUsuario.obtenerPorNombre("Bea").getEdad());
    }
}
