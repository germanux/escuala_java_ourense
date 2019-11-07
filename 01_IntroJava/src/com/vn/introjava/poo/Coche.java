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
public class Coche  extends Vehiculo {
    /* public Coche() {    
        // Constructor por defecto
    } */
    private int numRuedas = 4;
    private String marca;
    protected boolean arrancado;
    
    // En el momento que creamos un constructor, el de por defecto
    // deja de ser implementado por Java
    public Coche() {
        numRuedas = 4;
        marca = "SIN MARCA";
        this.arrancado = false;
        tipo = TipoVehiculo.TURISMO;
    }

    public Coche(String marca) {
        this.marca = marca;
        this.arrancado = false;
        tipo = TipoVehiculo.TURISMO;
    }
    
    public boolean arrancar() {
        System.out.println(this.marca + " ha arrancado.");
        arrancado = true;
        return arrancado;
    }
    // Sobrecarga de método arrancar()
    /** Si la posición de la llave es 4, el coche arranca
     *  No arranca en cualquier otro caso
     * @param posicionLlave  puede ser un nº del 1 al 4
     * @return              Si se ha arrancado devuelve true
     */
    public boolean arrancar(int posicionLlave) { // 4 pos, la 4ª arranca
        
        if (posicionLlave <1 || posicionLlave > 4)
            throw new IllegalArgumentException("La llave ha de valer de 1 a 4");
        
        arrancado = posicionLlave == 4 /*? true : false */;
        System.out.println(this.marca 
                + (arrancado ? " ha arrancado." 
                             : " fallo al arrancar") );
        // if (poscionLlave == 4) arrancado = true; else arrancado = false;
        return arrancado;
    }
    
    public boolean arrancar(String orden) {
    // CLEAN CODE: funciones no deber más 20 lineas código
        arrancado = "arrancar".equals(orden);
        return arrancado;
    }
    /**
     * Simplemente muestra la marca y si está arrancado
     */
    public void mostrarEstado() {
        System.out.println("Coche " + getMarca()
                + (arrancado ? " arrancado." 
                             : " apagado.") );
    }
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) 
            // Avisamos a quién invoca este método
            // que podríamos lanzar la siguiente excepción
        // throws IllegalArgumentException
            throws Exception
    {
        // Cuando existe una variable local con el mismo nombre
        // Obliga a usar this para acceder a la varible miembro
        // con el mismo nombre
        if (marca != null &&  !"".equals(marca))
            this.marca = marca;
        else    // Lanzamos la excepción
            throw new IllegalArgumentException("Dedes asignar una marca");
    }
    public int getNumRuedas() {
        return numRuedas;
    }

    public boolean isArrancado() {
        return arrancado;
    }

    @Override
    public void avanzar() {
        System.out.println("Ruedo un poco");
    }
}
