package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Settore;
import com.database.systems.fixture.common.entity.SquadraAvversaria;
import com.database.systems.fixture.repository.repositoryInterface.ISquadraAvversariaRepository;
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
public class SquadraAvversariaRepository implements ISquadraAvversariaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public SquadraAvversariaRepository() {
    }

    @Override
    public List<SquadraAvversaria> getAllSquadreAvversarie() {
        String hql = "FROM SquadraAvversaria as sqavv";
        return (List<SquadraAvversaria>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public SquadraAvversaria getSquadraAvversariaById(String nomeSquadra) {
        return entityManager.find(SquadraAvversaria.class, nomeSquadra);
    }

    @Override
    public void addSquadraAvversaria(SquadraAvversaria squadra) {
        entityManager.persist(squadra);
    }

    @Override
    public void updateSquadraAvversaria(SquadraAvversaria squadra) {
        SquadraAvversaria sqavv = getSquadraAvversariaById(squadra.getNome());
        sqavv.setNome(squadra.getNome());
        sqavv.setCitta(squadra.getCitta());
        entityManager.flush();
    }

    @Override
    public void deleteSquadraAvversaria(String nomeSquadra) {
        entityManager.remove(getSquadraAvversariaById(nomeSquadra));
    }

    @Override
    public boolean squadraAvversariaExists(String nomeSquadra) {
        String hql = "FROM SquadraAvversaria as sqavv WHERE sqavv.nome = ?1";
        int count = entityManager.createQuery(hql).setParameter(1, nomeSquadra).getResultList().size();
        return count > 0;
    }
}
