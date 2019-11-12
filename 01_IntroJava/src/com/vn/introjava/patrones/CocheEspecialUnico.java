/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.Random;

/**
 *
 * @author pc
 */
public class CocheEspecialUnico extends Coche {
    
    private static CocheEspecialUnico instancia;
    
    private CocheEspecialUnico() {
        super();
    }
    
    public static CocheEspecialUnico getInstancia () throws Exception {
        if (CocheEspecialUnico.instancia == null)  {            
            CocheEspecialUnico.instancia = new CocheEspecialUnico();
            
            CocheEspecialUnico.instancia.setMarca("UNICO COCHE " 
                + (new Random()).nextInt());
        }
        return CocheEspecialUnico.instancia;
    }
}
