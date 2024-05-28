/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejemplo1;

/**
 *
 * @author Abraham
 */
public class TareaJugador implements Runnable {
    private final Jugador jugador;

    public TareaJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void run() {
        try {
            // Simular el procesamiento del tiempo del jugador (esperar el tiempo del jugador)
            Thread.sleep(jugador.getTiempo());
            System.out.println("Procesado jugador: " + jugador.getNombre() + " con tiempo: " + jugador.getTiempo() + " en el hilo: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
