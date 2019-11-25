/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appusuarios.modelo;

/**
 *
 * @author pc
 */
public interface IGenericDao<T> {
    
    public abstract T crear(T  objetoNuevo);
    
    T obtenerPorId(int id);
    
    T obtenerTodos();
    
    T modificar(T objConDatosNuevo);
    
    boolean eliminar(int id);
}
