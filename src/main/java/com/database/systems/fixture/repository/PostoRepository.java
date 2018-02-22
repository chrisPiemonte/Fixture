package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Partita;
import com.database.systems.fixture.common.entity.Posto;
import com.database.systems.fixture.common.entity.composite.PostoId;
import com.database.systems.fixture.repository.repositoryInterface.IPartitaRepository;
import com.database.systems.fixture.repository.repositoryInterface.IPostoRepository;
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
public class PostoRepository implements IPostoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PostoRepository() {
    }


    @Override
    public List<Posto> getAllPosti() {
        String hql = "FROM Posto as p";
        return (List<Posto>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Posto getPostoById(PostoId postoId) {
        return entityManager.find(Posto.class, postoId);
    }

    @Override
    public void addPosto(Posto posto) {
        entityManager.persist(posto);
    }

    @Override
    public void updatePosto(Posto posto) {
        Posto pst = getPostoById(posto.getNumeroSettoreAnello());
        pst.setNumeroSettoreAnello(posto.getNumeroSettoreAnello());
        pst.setTipo(posto.getTipo());
        pst.setPrezzo(posto.getPrezzo());
        entityManager.flush();
    }

    @Override
    public void deletePosto(PostoId postoId) {
        entityManager.remove(getPostoById(postoId));
    }

    @Override
    public boolean postoExists(PostoId postoId) {
        String hql = "FROM Posto as pst WHERE pst.numeroSettoreAnello.numero = ?1 " +
                "AND pst.numeroSettoreAnello.settore = ?2 " +
                "AND pst.numeroSettoreAnello.anello = ?3";
        int count = entityManager.createQuery(hql)
                .setParameter(1, postoId.getNumero())
                .setParameter(2, postoId.getSettore())
                .setParameter(3, postoId.getAnello())
                .getResultList().size();
        return count > 0;
    }
}
