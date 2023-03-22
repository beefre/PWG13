package org.bedu.backend.postwork6.dao;

import org.bedu.backend.postwork6.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.SortedSet;
import java.util.TreeSet;

@Repository
public class AgendaDAO {

    private static SortedSet<Persona> personas = new TreeSet<>();

    public Persona guardaPersona(Persona persona) {
        personas.add(persona);
        return persona;
    }

    public SortedSet<Persona> getPersonas(){
        return personas;
    }
}
