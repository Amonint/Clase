/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejemplo2;

/**
 *
 * @author Abraham
 */
import java.util.ArrayList;
import java.util.Scanner;

class Alumno {
    private String nombre;
    private ArrayList<Double> calificaciones;

    public Alumno(String nombre) {
        this.nombre = nombre;
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCalificacion(double calificacion) {
        this.calificaciones.add(calificacion);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.size();
    }
}

public class PromedioAlumnos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir el nombre del alumno
        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();

        // Crear un objeto Alumno
        Alumno alumno = new Alumno(nombre);

        // Pedir las calificaciones del alumno
        System.out.println("Ingrese las calificaciones del alumno (escriba -1 para terminar):");
        while (true) {
            System.out.print("Ingrese una calificación: ");
            double calificacion = scanner.nextDouble();
            if (calificacion == -1) {
                break;
            }
            alumno.agregarCalificacion(calificacion);
        }

        // Calcular el promedio
        double promedio = alumno.calcularPromedio();

        // Imprimir el nombre del alumno y su promedio
        System.out.println("El promedio de " + alumno.getNombre() + " es: " + promedio);
    }
}
