/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appusuarios.modelo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pc
 */
public class ServicioUsuarios {

    UsuariosDAO daoUsu;

    public ServicioUsuarios() {
        daoUsu = new UsuariosDAO();
    }
    /** Método que comprueba primero si los campos son válidos de la siguiente
     * manera: Primero que ningún valor es nulo, segundo que no haya 
     * campos vacíos. La edad debe ser un número y por último que el 
     * email y el nombre sean correctos mediante expresiones regulares.
     * 
     * @param email
     * @param password
     * @param nombre
     * @param edad      Debe ser mayor de 12
     * @return          El objeto Usuario ya creado o nulo si está mal
     */
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
                    if (iEdad >= 12) {
                        if (validarEmailNombre(email, nombre)) {                            
                            Usuario usuario = new Usuario(-1, email, password, nombre, iEdad);
                            return usuario;
                        } else {
                            System.out.println("El nombre o el email no cumplen RegExp: " 
                                    + nombre + ", " + password);
                        }
                    } else {
                        System.out.println("La edad es menor de 12: " 
                                + edad);
                    }
                } catch (Exception e) {
                    System.out.println("La edad no se puede parsear a int: " + edad);
                }
            } else {
                System.out.println("Hay un campo que no cumple la longitud");
            }
        } else {
            System.out.println("No admite NULOS");
        }
        return null;
    }

    boolean validarEmailNombre(String email, String nombre) {
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            regex = "^[A-Z][a-z]+ ?[A-Za-z]*$";
            pattern = Pattern.compile(regex);
            matcher = pattern.matcher(nombre);

            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

public Usuario crear(String email, String password, String nombre, String edad) {
        Usuario nuevoUsu = crearUsuarioValido(email, password, nombre, edad);
        if (nuevoUsu != null) {
            nuevoUsu = daoUsu.crear(nuevoUsu);
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

    public Usuario modificar(int id, String email, String password, String nombre, String edad) {

        Usuario usuModif = crearUsuarioValido(email, password, nombre, edad);
        if (usuModif != null) {
            usuModif.setId(id);
            daoUsu.modificar(usuModif);
            return usuModif;
        }
        return null;
    }

    public boolean eliminar(int id) {
        return daoUsu.eliminar(id);
    }
    public ArrayList<Usuario> leerTodos() {
        return daoUsu.obtenerTodos();
    }
}
