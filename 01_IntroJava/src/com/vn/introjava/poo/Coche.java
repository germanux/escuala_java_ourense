/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 *
 * @author pc
 */
public class Coche  /* extends Object */ {
    /* public Coche() {    
        // Constructor por defecto
    } */
    private int numRuedas = 4;
    private String marca;
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        // Cuando existe una variable local con el mismo nombre
        // Obliga a usar this para acceder a la varible miembro
        // con el mismo nombre
        this.marca = marca;
    }
}
