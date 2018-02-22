package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Persona;
import com.database.systems.fixture.repository.repositoryInterface.IPersonaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Transactional
@Repository
public class PersonaRepository implements IPersonaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PersonaRepository() {
    }

    @Override
    public List<Persona> getAllPersone() {
        String hql = "FROM Persona as a";
        return (List<Persona>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Persona getPersonaById(String cf) {
        return entityManager.find(Persona.class, cf);
    }

    @Override
    public void addPersona(Persona persona) {
        entityManager.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        Persona prs = getPersonaById(persona.getCf());
        prs.setCf(persona.getCf());
        prs.setNome(persona.getNome());
        prs.setCognome(persona.getCognome());
        prs.setTipo(persona.getTipo());
        prs.setData_nascita(persona.getData_nascita());
        prs.setLuogo_nascita(persona.getLuogo_nascita());
        prs.setTelefono(persona.getTelefono());
        entityManager.flush();
    }

    @Override
    public void deletePersona(String cf) {
        entityManager.remove(getPersonaById(cf));
    }

    @Override
    public boolean personaExists(String cf) {
        String hql = "FROM Persona as prs WHERE prs.cf = ?1";
        int count = entityManager.createQuery(hql)
                .setParameter(1, cf)
                .getResultList().size();
        return count > 0;
    }
}
