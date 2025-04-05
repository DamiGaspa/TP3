package oop2.tp3.ejercicio4;

import org.jdbi.v3.core.Jdbi;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        var repo = new PersonaRepository(jdbi);
        var personas = repo.buscarPorNombre("Vla");

        if (hayPersonas(personas)) {
            for (Persona persona : personas) {
                System.out.println(persona.nombre() + " " + persona.apellido());
            }
        }

        var persona = repo.buscarId(1L);
        if (personaExiste(persona)) {
            System.out.println(persona.nombre() + " " + persona.apellido());
        }
    }

    private static boolean personaExiste(Persona persona) {
        return persona != null;
    }

    private static boolean hayPersonas(List<Persona> personas) {
        return personas != null;
    }
}
