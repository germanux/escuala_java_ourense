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
public class ServicioUsuarios {
    
    UsuariosDAO daoUsu;

    public ServicioUsuarios() {
        daoUsu = new UsuariosDAO();
    }
    public Usuario crearUsuarioValido(String email, String password, String nombre, String edad) {
        
        if (email != null 
                && password != null 
                && nombre != null 
                && edad != null) 
        {
            if (email.length() >= 3 
                    && nombre.length() > 1 
                    && password.length() >= 4 
                    && !"".equals(edad))
            {
                try {
                    int iEdad = Integer.parseInt(edad);
                    if ( iEdad > 12) {
                        Usuario usuario = new Usuario(-1, email, password, nombre, iEdad);
                        return usuario;
                    } else {
                        return null;
                    }                    
                }catch (Exception e) {                    
                    System.out.println("La edad no se puede parsear a int: " + edad);
                    return null;
                }
            } else {
                System.out.println("Hay un campo que no cumple la longitud");
                return null;
            }
        } else {
            System.out.println("No admite NULOS");
            return null;
        }
    }
    
    public Usuario crear(String email, String password, String nombre, String edad) {
        Usuario nuevoUsu = crearUsuarioValido(email, password, nombre, edad);
        if (nuevoUsu != null) {
            daoUsu.crear(nuevoUsu);
            return nuevoUsu;
        }
        return null;
    }
    public Usuario leerUno(int id) {
        return daoUsu.obtenerPorId(id);
    }
    public Usuario leerUno(String email) {
        return daoUsu.obtenerPorEmail(email);
    }
}
