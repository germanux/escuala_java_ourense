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
    public Coche crear(String marca) throws Exception {
        
        return crear(FabricaCoches.crear(marca));
    }
    @Override
    public Coche crear(Coche coche) throws Exception {
        mapaStr.put(coche.getMarca(), coche);
        mapaInt.put(ultimoIndex, coche); // mapaStr.get(coche.getMarca()));
        ultimoIndex++;
        return coche;
    }
    @Override
    public Coche obtenerPorIndice(int index) {
        return mapaInt.get(index);
    }
    @Override
    public Coche obtenerPorMarca(String marca) {
        return mapaStr.get(marca);
    }

    @Override
    public Coche modificar(int index, Coche objConDatosNuevo) throws Exception {
        Coche c = obtenerPorIndice(index);
        c.setMarca(objConDatosNuevo.getMarca());
        c.setTipo(objConDatosNuevo.getTipo());
        c.arrancar(objConDatosNuevo.isArrancado() 
            ? 4 : 1);    
        return c;
    }

    @Override
    public void eliminar(int index) {
        // Eliminamos por marca (String)
        Coche c = mapaInt.get(index);
        mapaStr.remove(c.getMarca());
        // Eliminamos por indice (Integer)
        mapaInt.remove(index);
    }

    @Override
    public void eliminar(Coche cocheAeliminar) {
        String keyMarca = cocheAeliminar.getMarca();
        mapaStr.remove(keyMarca);
        
        int keyIndex = -1;
        if (mapaInt.containsValue(cocheAeliminar)) {
            for (Map.Entry<Integer, Coche> parIndexYcoche : mapaInt.entrySet()) {
                if (parIndexYcoche.getValue().equals(cocheAeliminar)) {
                    keyIndex = parIndexYcoche.getKey();
                }
            }
        }
        mapaInt.remove(keyIndex);
    }
}
