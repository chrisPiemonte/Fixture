package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Stagione;
import com.database.systems.fixture.repository.repositoryInterface.IStagioneRepository;
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
public class StagioneRepository implements IStagioneRepository {

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
    public Stagione getStagioneById(String stagioneId) {
        return entityManager.find(Stagione.class, stagioneId);
    }

    @Override
    public void addStagione(Stagione stagione) {
        entityManager.persist(stagione);
    }

    @Override
    public void updateStagione(Stagione stagione) {
        Stagione stg = getStagioneById(stagione.getAnno());
        stg.setAnno(stagione.getAnno());
        entityManager.flush();
    }

    @Override
    public void deleteStagione(String stagioneId) {
        entityManager.remove(getStagioneById(stagioneId));
    }

    @Override
    public boolean stagioneExists(String anno) {
        String hql = "FROM Stagione as stg WHERE stg.anno = ?1";
        int count = entityManager.createQuery(hql).setParameter(1, anno).getResultList().size();
        return count > 0;
    }

}
