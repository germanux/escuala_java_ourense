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
        srvUsu.crear("a@a.a", "1234", "Nom 1", "20");
        srvUsu.crear("a@a.a2", "1234", "Nom 2", "30");
        
        assertTrue(srvUsu.leerUno("a@a.a").getId() > 0);
        assertEquals("Nom 2", srvUsu.leerUno("a@a.a2").getNombre());
    }
    @Test
    public void modificarUsuariosInvalidos() {
    }
    @Test
    public void modificarUsuariosValidos() {
    }
    @Test
    public void eliminarUsuarios() {
    }
}
