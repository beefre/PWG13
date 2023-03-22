package org.bedu.backend.postwork6.service;

import org.bedu.backend.postwork6.dao.AgendaDAO;
import org.bedu.backend.postwork6.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class AgendaService {

    TelefonoService telefonoService;
    AgendaDAO agendaDAO;

    @Autowired
    public AgendaService(AgendaDAO agendaDAO, TelefonoService telefonoService){
        this.agendaDAO = agendaDAO;
        this.telefonoService = telefonoService;
    }

    public Persona guardarPersona(Persona persona){
        String telefono = telefonoService.limpiaNumero(persona.getTelefono());
        boolean isValido = telefonoService.isValido(telefono);
        if(!isValido){
            return null;
        }
        persona.setTelefono(telefonoService.formatea(telefono));
        return agendaDAO.guardaPersona(persona);
    }

    public SortedSet<Persona> getPersonas(){
        return agendaDAO.getPersonas();
    }
}
