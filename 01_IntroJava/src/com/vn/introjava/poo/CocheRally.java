/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/** Clase CocheRally para controlar otras características
 * específicas de los rallies
 *
 * @author pc
 */
public class CocheRally extends Coche {
    
    private float rozamiento;

    public CocheRally() {
        super();
        rozamiento = 5f;
        tipo = TipoVehiculo.RALLY;
    }
    
    /** Contructor con parámetros
     *  AL implementar un constructor, el de por defecto
     *  deja de ser implementado por Java
     * @param marca 
     */
    public CocheRally(String marca) {
        super(marca);
        rozamiento = 5f;
        tipo = TipoVehiculo.RALLY;
    }   

    public CocheRally(float rozamiento, String marca) {
        super(marca);
        this.rozamiento = rozamiento;
        tipo = TipoVehiculo.RALLY;
    }
    
    /**
     * Obtener valor de rozamiento
     *
     * @return the value of rozamiento
     */
    public float getRozamiento() {
        return rozamiento;
    }

    /**
     * Establecer valor de rozamiento
     *
     * @param rozamiento new value of rozamiento
     */
    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }
    
    public boolean arrancar(String orden, int posLLave) {
        if (super.arrancar(orden) && super.arrancar(posLLave))
            return super.arrancar();
        else
            return super.arrancar("NO arrancar");
    }

    @Override
    public boolean arrancar(String orden) {
        if (super.arrancar(orden))
            return super.arrancado;
        else if ("arrancar".equalsIgnoreCase(orden)) 
            arrancado = true;
        else 
            arrancado = "encender".equals(orden.toLowerCase());
   
        return arrancado;
    }
    // Ejercicio: 
    // 1ro 1Sobreescribir el método mostrarEstado para que
    // también muestre el rozamiento
    
    // @Override
    public void mostrarEstadoAntiguo() {
        super.mostrarEstado();
        System.out.println("   - Rozamiento: " + getRozamiento());
    }
    // 2do, el metodo anterior ya no vale, renombrar a mostrarEstadoAntiguo()
    // que indique que es "Coche de rally: <marca>, rozamiento, arrancado"


    @Override
    public String toString() {
        return tipo + ": " + getMarca()
                + ", rozam = " + rozamiento 
                + (isArrancado() ? " arrancado." 
                             : " apagado.");
    }
    
    
}
