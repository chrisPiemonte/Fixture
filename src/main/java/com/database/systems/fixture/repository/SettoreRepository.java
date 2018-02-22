package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Settore;
import com.database.systems.fixture.repository.repositoryInterface.ISettoreRepository;
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
public class SettoreRepository implements ISettoreRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public SettoreRepository() {
    }

    @Override
    public List<Settore> getAllSettori() {
        String hql = "FROM Settore as a";
        return (List<Settore>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Settore getSettoreById(String settoreId) {
        return entityManager.find(Settore.class, settoreId);
    }

    @Override
    public void addSettore(Settore settore) {
        entityManager.persist(settore);
    }

    @Override
    public void updateSettore(Settore settore) {
        Settore str = getSettoreById(settore.getId());
        str.setId(settore.getId());
        str.setNome(settore.getNome());
        str.setPrezzoBase(settore.getPrezzoBase());
        entityManager.flush();
    }

    @Override
    public void deleteSettore(String settoreId) {
        entityManager.remove(getSettoreById(settoreId));
    }

    @Override
    public boolean settoreExists(String settoreId) {
        String hql = "FROM Settore as str WHERE str.id = ?1";
        int count = entityManager.createQuery(hql).setParameter(1, settoreId).getResultList().size();
        return count > 0;
    }
}
