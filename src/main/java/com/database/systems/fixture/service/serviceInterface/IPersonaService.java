package com.database.systems.fixture.service.serviceInterface;

import com.database.systems.fixture.common.entity.Persona;
import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IPersonaService {

    List<Persona> getAllPersone();

    Persona getPersonaById(String cf);

    boolean addPersona(Persona persona);

    void updatePersona(Persona persona);

    void deletePersona(String cf);

}
