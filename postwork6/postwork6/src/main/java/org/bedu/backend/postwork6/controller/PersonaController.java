package org.bedu.backend.postwork6.controller;

import org.bedu.backend.postwork6.model.Persona;
import org.bedu.backend.postwork6.service.FormatearTelefono;
import org.bedu.backend.postwork6.service.PersonaService;
import org.bedu.backend.postwork6.service.ValidarTelefono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.SortedSet;

@RestController
public class PersonaController {

    @Autowired
    private ValidarTelefono validarTelefono;
    @Autowired
    private FormatearTelefono formatearTelefono;
    @Autowired
    private PersonaService personaService;

    @PostMapping("/api/v1/personas")
    public ResponseEntity<Persona> creaPersona(@RequestBody Persona persona){

        Persona personaRegistrada = personaService.guardarPersona(persona);
        if(personaRegistrada == null){
            return ResponseEntity.badRequest().body(personaRegistrada);
        }

        return ResponseEntity.ok(persona);
    }

    @GetMapping("/api/v1/personas")
    public ResponseEntity<SortedSet<Persona>> getPersonas(){
        return ResponseEntity.ok(personaService.getPersonas());
    }
}
