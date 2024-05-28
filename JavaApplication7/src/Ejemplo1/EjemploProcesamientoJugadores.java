/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo1;

/**
 *
 * @author Abraham
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EjemploProcesamientoJugadores {
    public static void main(String[] args) {
        // Crear una lista de jugadores con tiempos aleatorios
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Alice", (int) (Math.random() * 1000)));
        jugadores.add(new Jugador("Bob", (int) (Math.random() * 1000)));
        jugadores.add(new Jugador("Carlos", (int) (Math.random() * 1000)));
        jugadores.add(new Jugador("Diana", (int) (Math.random() * 1000)));
        jugadores.add(new Jugador("Eva", (int) (Math.random() * 1000)));

        // Crear un ExecutorService con un pool de hilos fijo de 3 hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Crear y enviar tareas al ExecutorService para cada jugador
        for (Jugador jugador : jugadores) {
            TareaJugador tarea = new TareaJugador(jugador);
            executor.submit(tarea);
        }

        // Ordenar el cierre del executor después de terminar todas las tareas
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Esperar a que todas las tareas terminen
        }

        // Ordenar a los jugadores por tiempo
        Collections.sort(jugadores, Comparator.comparingInt(Jugador::getTiempo));

        // Imprimir los jugadores ordenados
        System.out.println("Jugadores ordenados por tiempo:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }
}
