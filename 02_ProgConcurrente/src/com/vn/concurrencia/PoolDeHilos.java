/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author pc
 */
public class PoolDeHilos {

    private final long numHilos;
    private Set<Runnable> setHilosAB;

    public PoolDeHilos(long numHilosAB) {
        this.numHilos = numHilosAB;
        setHilosAB = new HashSet<>();   // NO mantiene el orden inserción
        for (int i = 0; i < numHilos; i++) {
            setHilosAB.add(new HilosSencillos.HiloA());
            setHilosAB.add(new HilosSencillos.HiloB(8000000));
        }
    }

    public void ejecturarHilosRunABenSerie() {
        System.out.println("\n---- " + numHilos + " hilos - SERIE ----\n");
        // SIN HILOS, ejecutamos uno detrás de otro

        for (Runnable hiloAB : setHilosAB) {
            hiloAB.run();
        }
        System.out.println("\n---- end - SERIE ----\n");
    }

    public void ejecutarHilosStartABenParalelo() {
        System.out.println("\n**** " + numHilos + " hilos - PARALELO ****\n");
        
        HashSet<Thread> setThreads = new HashSet<>();  // Mantiene el orden inserción

        // Forma fácil de recorrer una colección
        for (Runnable hiloAB : setHilosAB) {

            setThreads.add(new Thread(hiloAB));
        }
        // Forma funcional de recorrer una coleccion mediante funcion lambda        
        setThreads.forEach((threadHiloAB) -> {
            // Necesitamos dos bucles?
            threadHiloAB.start();
        });
        boolean hayUnoVivo = false;  // Con un booleano tambien sirve
        do {
            hayUnoVivo = false;

            // En realidad, ambas maneras encubren esta manera, un objeto que 
            // nos ayuda con la iteracion. Implementacion tipica del 
            // PATRON ITERATOR
            // Perdon por la falta de acentos, no me va el teclado espanhol
            Iterator<Thread> it = setThreads.iterator();
            while ( it.hasNext()) {
                Thread threadHiloAB = it.next();
                hayUnoVivo = hayUnoVivo || threadHiloAB.isAlive();
/*                if (threadHiloAB.isAlive()) {  // Para quitar este IF?
                    hayUnoVivo = true;
                }*/
            };
        } while (hayUnoVivo);

        System.out.println("\n**** end - START ****\n");
    }
}
