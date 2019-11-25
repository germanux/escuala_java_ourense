/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.appusuarios.modelo.ServicioUsuarios;
import com.appusuarios.modelo.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestServicioUsuarios {
    
    private ServicioUsuarios srvUsu;
    
    public TestServicioUsuarios() {
        srvUsu = new ServicioUsuarios();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void crearUsuariosInvalidos() {
        Usuario u1 = srvUsu.crear(null, "", null, "");
        Usuario u2 = srvUsu.crear("", "a1", "Nom", "");
        Usuario u3 = srvUsu.crear("b@a.a", "a1", "", "");
        Usuario u4 = srvUsu.crear("b@a.a", "1234", "Nom 2", "SIN EDAD");
        Usuario u5 = srvUsu.crear("b@a.a", "1234", "Nom 2", "10");
        assertNull(u1);
        assertNull(u2);
        assertNull(u3);
        assertNull(u4);
        assertNull(u5);
        assertNull(srvUsu.leerUno("b@a.a"));
    }
    @Test
    public void crearUsuariosValidos() {
        Usuario u1 = srvUsu.crear("a@a.a", "1234", "Nom 1", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom 2", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom 3", "40");
        
        assertTrue(srvUsu.leerUno("a@a.a").getId() > 0);
        assertEquals("Nom 2", srvUsu.leerUno("a@a.a2").getNombre());
        assertEquals("Nom 3", srvUsu.leerUno("a@ee.a2").getNombre());
        
        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
    }
    @Test
    public void modificacionesInvalidasDeUsuarios() {
    }
    @Test
    public void modificarUsuariosValidos() {
        Usuario u1 = srvUsu.crear("a@a.a", "1234", "Nom 1", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom 2", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom 3", "40");
        
        srvUsu.modificar(u1.getId(), u1.getEmail(), u1.getPassword(), u1.getNombre(), "25");
        assertEquals(25, srvUsu.leerUno("a@a.a").getEdad());
        srvUsu.modificar(u2.getId(), "psd@dd.ee", u2.getPassword(), u2.getNombre(), "30");
        assertEquals(u2.getId(), srvUsu.leerUno("psd@dd.ee").getId());
        
        srvUsu.modificar(u3.getId(), "a@ee.a2", "666uu", "Otro nombre", "40");
        assertEquals("666uu", srvUsu.leerUno(u3.getId()).getPassword());
        assertEquals("Otro nombre", srvUsu.leerUno("a@ee.a2").getNombre());
        
        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
    }
    @Test
    public void eliminarUsuarios() {
        Usuario u1 = srvUsu.crear("a@a.a", "1234", "Nom 1", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom 2", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom 3", "40");
        
        boolean b1 = srvUsu.eliminar(u1.getId());        
        boolean b2 = srvUsu.eliminar(u2.getId());        
        boolean b3 = srvUsu.eliminar(u3.getId());
        
        assertNull(srvUsu.leerUno("a@a.a"));
        assertNull(srvUsu.leerUno(u2.getId()));
        assertNull(srvUsu.leerUno("a@ee.a2"));
        assertTrue(b1 && b2 && b3); //, "Alguno eliminarUsuarios ha fallado");
    }
}
