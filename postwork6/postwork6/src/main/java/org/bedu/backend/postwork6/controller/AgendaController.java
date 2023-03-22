package org.bedu.backend.postwork6.controller;

import org.bedu.backend.postwork6.model.Persona;
import org.bedu.backend.postwork6.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.SortedSet;

@RestController
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/api/v1/personas")
    public ResponseEntity<Persona> creaPersona(@RequestBody Persona persona){

        Persona personaRegistrada = agendaService.guardarPersona(persona);
        if(personaRegistrada == null){
            return ResponseEntity.badRequest().body(personaRegistrada);
        }

        return ResponseEntity.ok(persona);
    }

    @GetMapping("/api/v1/personas")
    public ResponseEntity<SortedSet<Persona>> getPersonas(){
        return ResponseEntity.ok(agendaService.getPersonas());
    }
}
