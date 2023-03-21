package org.bedu.backend.postwork6.service;

import org.bedu.backend.postwork6.dao.PersonaDAO;
import org.bedu.backend.postwork6.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class PersonaService {

    @Autowired
    TelefonoService telefonoService;
    @Autowired
    PersonaDAO personaDAO;

    public Persona guardarPersona(Persona persona){
        String telefono = telefonoService.limpiaNumero(persona.getTelefono());
        boolean isValido = telefonoService.isValido(telefono);
        if(!isValido){
            return null;
        }
        persona.setTelefono(telefonoService.formatea(telefono));
        return personaDAO.guardaPersona(persona);
    }

    public SortedSet<Persona> getPersonas(){
        return personaDAO.getPersonas();
    }
}
