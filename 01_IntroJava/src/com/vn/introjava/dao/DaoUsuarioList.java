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
    public Usuario crear(Usuario nuevoUsuario) throws Exception {
        listaUsuarios.add(nuevoUsuario);
        return nuevoUsuario;
    }
    public Usuario crear(String nom, int edad) throws Exception {
        return crear(new Usuario(nom, edad));
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

    @Override
    public Usuario modificar(int index, Usuario usuarioConDatos) throws Exception {
        
        Usuario usuarioAmodificar = listaUsuarios.get(index);
        usuarioAmodificar.setEdad(usuarioConDatos.getEdad());
        usuarioAmodificar.setNombre(usuarioConDatos.getNombre());
        // listaUsuarios.set(index, usuarioConDatos);
        return usuarioAmodificar;
    }

    @Override
    public void eliminar(int index) {
         this.listaUsuarios.remove(index);
        // eliminar(obtenerPorIndice(index)); // OK también, en este caso es más lento
    }

    @Override
    public void eliminar(Usuario objConDatosNuevo) {
        this.listaUsuarios.remove(objConDatosNuevo);
    }
}
