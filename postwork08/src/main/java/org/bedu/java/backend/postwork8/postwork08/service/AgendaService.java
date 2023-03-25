package org.bedu.java.backend.postwork8.postwork08.service;

import org.bedu.java.backend.postwork8.postwork08.dao.PersonaRepository;
import org.bedu.java.backend.postwork8.postwork08.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AgendaService {

    private final ValidadorTelefono validadorTelefono;
    private final PersonaRepository personaRepository;

    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, PersonaRepository personaRepository) {
        this.validadorTelefono = validadorTelefono;
        this.personaRepository = personaRepository;
    }

    public Persona guardaPersona(Persona persona) {
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return personaRepository.save(persona);
    }

    public List<Persona> getPersonas() {
        return personaRepository.findAll(Sort.by("nombre"));
    }
}