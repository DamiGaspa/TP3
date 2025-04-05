package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;

    public Cliente(String nombre) {
        this.name = nombre;
    }

    public Object[] calcularDeudaYPuntosObtenidos() {
        Object[] resultado = new Object[2];
        double total = 0;
        int puntosAlquilerFrecuente = 0;
        for (Alquiler alquiler : alquileres) {
            double monto = 0;
// determine amounts for each line
            switch (precioLibro(alquiler)) {
                case Libro.REGULARES:
                    monto += 2;
                    if (seAlquiloDias(alquiler, 2))
                        monto += descuento(alquiler, 2);
                    break;
                case Libro.NUEVO_LANZAMIENTO:
                    monto += alquiler.diasAlquilados() * 3;
                    break;
                case Libro.INFANTILES:
                    monto += 1.5;
                    if (seAlquiloDias(alquiler, 3))
                        monto += descuento(alquiler, 3);
                    break;
            }
            total += monto;
            // sumo puntos por alquiler
            puntosAlquilerFrecuente++;
            // bonus por dos días de alquiler de un nuevo lanzamiento
            if ((precioLibro(alquiler) == Libro.NUEVO_LANZAMIENTO)
                    && seAlquiloDias(alquiler, 1)) {
                puntosAlquilerFrecuente++;
            }
        }
        resultado[0] = total;
        resultado[1] = puntosAlquilerFrecuente;
        return resultado;
    }

    private static double descuento(Alquiler alquiler, int puntos) {
        return (alquiler.diasAlquilados() - puntos) * 1.5;
    }

    private static boolean seAlquiloDias(Alquiler alquiler, int dias) {
        return alquiler.diasAlquilados() > dias;
    }

    private static int precioLibro(Alquiler alquiler) {
        return alquiler.copia().libro().codigoPrecio();
    }

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }
}