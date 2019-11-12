/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.patrones;

import com.vn.introjava.patrones.CocheEspecialUnico;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbandoUnicaInstancia {
    
     @Test
    public void intentarUnicaInsTrisTras() throws Exception {
         CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();
         
         // miUnicoCoche.setMarca("UNICO COCHE 3");
         miUnicoCoche.mostrarEstado();
    }
     @Test
    public void intentarUnicaIns() throws Exception {
         // CocheEspecialUnico.unicoCocheEsp = miUnicoCoche;
         // miUnicoCoche.setMarca("UNICO COCHE 1");
         CocheEspecialUnico.getInstancia().mostrarEstado();
    }    
     @Test
    public void intentarUnicaInsBis() throws Exception {
        CocheEspecialUnico.getInstancia().mostrarEstado();
    }  
     @Test
    public void intentarUnicaInsTris() throws Exception {
        CocheEspecialUnico.getInstancia().mostrarEstado();
    }
}
