/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DaoUsuarioList implements IDaoUsuario {
    
    private List<Usuario> listaUsuarios; 
    
    public DaoUsuarioList() {
        listaUsuarios = new ArrayList<>();
    }
    @Override
    public void crear(Usuario nuevoUsuario) throws Exception {
        listaUsuarios.add(nuevoUsuario);
    }
    public void crear(String nom, int edad) throws Exception {
        listaUsuarios.add(new Usuario(nom, edad));
    }
    @Override
    public Usuario obtenerPorIndice(int index) {
        return listaUsuarios.get(index);
    }
    @Override
    public Usuario obtenerPorNombre(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }
}
