package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  EL sistema de bloque lo tiene que gestionar
 *  el recurso compartido.
 * 
 * @author pc
 */
public class Contenedor {
    // Normalmente será un array, lista, bb.dd., 
    // mapa, fichero, DAO, servicio web, cualquier recurso compartido...
    int dato;
    // Semáforo: false no se puede usar el recurso
    //           true sí se puede usar
    boolean hayDato = false;
    
    // synchronized prepara el método para el bloqueo
    public synchronized int get() {  
        
        System.out.println("     GET: Empezando a esperar, hayDato = " + hayDato);
        while (hayDato == false)   // Esperamos a que se produzca algún dato
        {
            System.out.println("     GET: Esperando, hayDato = " + hayDato);
            try {
                this.wait();        // Le decimos al hilo que espere
                                    // hasta que el productor produzca el dato
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hayDato = false;            // Marcamos para bloquear el recurso antes de devolverlo
        System.out.println("<<<< Contenedor. GET hecho: " + dato);
        this.notifyAll();           // Indicar al hilo que avise a los otro hilos
                                    //    de que el recurso ha sido consumido
        return dato;                // Devolver el dato   
    }
    public synchronized void put(int valor) {
        
        System.out.println("     PUT: Empezando a esperar, hayDato = " + hayDato);  
        while (hayDato )    // Esperar a que alguien consuma el dato
        {
                            // Mientras hay dato, nadie lo ha consumido   
            System.out.println("     PUT: Esperando, hayDato = " + hayDato);    
            try {
                this.wait();        // Le decimos al hilo que espere
                                    // hasta que el productor produzca el dato
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }                     
        }        
        dato = valor;       // Almacenar el dato
        hayDato = true;     // Marcamos para des-bloquear/liberar el recurso
        System.out.println(">>>> Contenedor. PUT hecho: " + valor);
        
        this.notifyAll();
    }
}
