/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author pc
 */
public class DaoCocheMap implements IDaoCoche{
    
    private int ultimoIndex;
    Map<String, Coche> mapaStr;
    Map<Integer, Coche> mapaInt;
    
    public DaoCocheMap() {
        mapaStr = new TreeMap<>();
        mapaInt = new TreeMap<>();
        ultimoIndex = 0;
    }
    @Override
    public void crear(String marca) throws Exception {
        mapaStr.put(marca, FabricaCoches.crear(marca));
        mapaInt.put(ultimoIndex, mapaStr.get(marca));
        ultimoIndex++;
    }
    public Coche obtenerPorIndice(int index) {
        return mapaInt.get(index);
    }
    public Coche obtenerPorMarca(String marca) {
        return mapaStr.get(marca);
    }
}
