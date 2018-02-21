package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Persona;
import com.database.systems.fixture.repository.repositoryInterface.IPersonaRepository;
import com.database.systems.fixture.service.serviceInterface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private IPersonaRepository personaRepository;

    @Override
    public List<Persona> getAllPersone() {
        return personaRepository.getAllPersone();
    }

    @Override
    public Persona getPersonaById(String cf) {
        return personaRepository.getPersonaById(cf);
    }

    @Override
    public boolean addPersona(Persona persona) {
        if (personaRepository.personaExists(persona.getCf()))
            return false;
        else {
            personaRepository.addPersona(persona);
            return true;
        }
    }

    @Override
    public void updatePersona(Persona persona) {
        personaRepository.updatePersona(persona);
    }

    @Override
    public void deletePersona(String cf) {
        personaRepository.deletePersona(cf);
    }
}
