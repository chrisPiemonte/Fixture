package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Anello;
import com.database.systems.fixture.repository.repositoryInterface.IAnelloRepository;
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
public class AnelloRepository implements IAnelloRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public AnelloRepository() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Anello> getAllAnelli() {
        String hql = "FROM Anello as a";
        return (List<Anello>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Anello getAnelloById(String anelloId) {
        return entityManager.find(Anello.class, anelloId);
    }

    @Override
    public void addAnello(Anello anello) {
        entityManager.persist(anello);
    }

    @Override
    public void updateAnello(Anello anello) {
        Anello anl = getAnelloById(anello.getId());
        anl.setId(anello.getId());
        anl.setNome(anello.getNome());
        anl.setPrezzoBase(anello.getPrezzoBase());
        entityManager.flush();
    }

    @Override
    public void deleteAnello(String anelloId) {
        entityManager.remove(getAnelloById(anelloId));
    }

    @Override
    public boolean anelloExists(String anelloId) {
        String hql = "FROM Anello as anl WHERE anl.id = ?1";
        int count = entityManager.createQuery(hql).setParameter(1, anelloId).getResultList().size();
        return count > 0;
    }
}
