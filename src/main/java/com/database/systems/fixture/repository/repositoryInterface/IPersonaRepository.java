package com.database.systems.fixture.repository.repositoryInterface;

import com.database.systems.fixture.common.entity.Persona;
import com.database.systems.fixture.common.entity.composite.PartitaId;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IPersonaRepository {

    List<Persona> getAllPersone();

    Persona getPersonaById(String cf);

    void addPersona(Persona persona);

    void updatePersona(Persona persona);

    void deletePersona(String cf);

    boolean personaExists(String cf);


}
