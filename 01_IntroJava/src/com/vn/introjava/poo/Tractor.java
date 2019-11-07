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
public class Tractor extends Vehiculo {

    public Tractor() {
        super();
        tipo = TipoVehiculo.TRACTOR;
    }    
    
    @Override
    public void avanzar() {
        System.out.println("Ruedo y siego.");
    }    


    @Override
    public String toString() {
        return tipo.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
