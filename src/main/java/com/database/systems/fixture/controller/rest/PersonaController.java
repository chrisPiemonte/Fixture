package com.database.systems.fixture.controller.rest;

import com.database.systems.fixture.common.entity.Persona;
import com.database.systems.fixture.service.serviceInterface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Controller
@RequestMapping("api")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("persone")
    public ResponseEntity<List<Persona>> getAllPersone() {
        List<Persona> list = personaService.getAllPersone();
        return new ResponseEntity<List<Persona>>(list, HttpStatus.OK);
    }

    @GetMapping("persona/{cf}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable("cf") String cf) {
        Persona persona = personaService.getPersonaById(cf);
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

    @PostMapping("persona")
    public ResponseEntity<Void> addPersona(@RequestBody Persona persona, UriComponentsBuilder builder) {
        boolean flag = personaService.addPersona(persona);
        if (!flag) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/persona/{cf}").buildAndExpand(persona.getCf()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("persona")
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
        personaService.updatePersona(persona);
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

    @DeleteMapping("persona/{cf}")
    public ResponseEntity<Void> deletePersona(@PathVariable("cf") String cf) {
        personaService.deletePersona(cf);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
