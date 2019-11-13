/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;

/**
 *
 * @author pc
 */
public interface IDaoCoche extends IGenericDao<Coche> {
    
    public Coche crear(String marca) throws Exception; 
    
    public Coche obtenerPorMarca(String marca);
    
}
