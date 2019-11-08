/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.interfaces;

/** La forma en que se comunican las clases que la implementen
 * Es cómo una clase abstracta con sólo métodos abstractos
 *
 * @author pc
 */
public interface Desplazable {
    
    // No se deben usar variables miembro en interfaces
    // int propiedadNoApropiada = 4;
    
    // Únicamente declaración de métodos abstractos públicos
     /* public abstract*/ void mover(float metros);
    
    // public void mover(int metros);
    
    // public void detener();   
    // Sólo se puede implementar a partir de la java 10
//    public void mover(int m) {
//        
//    }
}
