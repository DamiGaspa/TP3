package oop2.tp3.ejercico1;

import oop2.tp3.ejercicio1.Alquiler;
import oop2.tp3.ejercicio1.Cliente;
import oop2.tp3.ejercicio1.CopiaLibro;
import oop2.tp3.ejercicio1.Libro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlquilerTest {
    @Test
    public void test() {
        Cliente cliente = new Cliente("Damian");
        Libro libro = new Libro("Mas alla de lo cotidiano", 15000);
        Alquiler alquiler = new Alquiler(new CopiaLibro(libro), 5);

        alquiler.diasAlquilados();
        cliente.alquilar(alquiler);
        cliente.calcularDeudaYPuntosObtenidos();

        assertTrue(alquiler.diasAlquilados() == 5);
    }
}
