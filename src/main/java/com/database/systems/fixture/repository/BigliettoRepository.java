package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Biglietto;
import com.database.systems.fixture.repository.repositoryInterface.IBigliettoRepository;
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
public class BigliettoRepository implements IBigliettoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BigliettoRepository() {
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Biglietto> getAllBiglietti() {
        String hql = "FROM Biglietto as b";
        return (List<Biglietto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Biglietto getBigliettoById(int bigliettoId) {
        return entityManager.find(Biglietto.class, bigliettoId);
    }

    @Override
    public Biglietto addBiglietto(Biglietto biglietto) {
        entityManager.persist(biglietto);
        entityManager.flush();
        return biglietto;
    }

    @Override
    public void updateBiglietto(Biglietto biglietto) {
        // TODO
    }

    @Override
    public void deleteBiglietto(int bigliettoId) {
        // TODO
    }

    @Override
    public boolean bigliettoExists(int bigliettoId) {
        String hql = "FROM Biglietto as b WHERE b.id = ?1";
        int count = entityManager.createQuery(hql).setParameter(1, bigliettoId).getResultList().size();
        return count > 0;
    }
}
