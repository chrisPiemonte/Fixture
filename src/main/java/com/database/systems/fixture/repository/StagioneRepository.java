package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Stagione;
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
public class StagioneRepository implements IStagioneRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public StagioneRepository() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Stagione> getAllStagioni() {

        String hql = "FROM Stagione as s ORDER BY s.anno";
        return (List<Stagione>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Stagione getStagioneById(int stagioneId) {
        return null;
    }

    @Override
    public void addStagione(Stagione stagione) {

    }

    @Override
    public void updateStagione(Stagione stagione) {

    }

    @Override
    public void deleteStagione(int stagioneId) {

    }

    @Override
    public boolean StagioneExists(String anno) {
        return false;
    }

}
