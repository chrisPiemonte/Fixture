package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Partita;
import com.database.systems.fixture.common.entity.composite.PartitaId;
import com.database.systems.fixture.repository.repositoryInterface.IPartitaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Transactional
@Repository
public class PartitaRepository implements IPartitaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PartitaRepository() {
    }

    @Override
    public List<Partita> getAllPartite() {
        String hql = "FROM Partita as p";
        return (List<Partita>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Partita getPartitaById(PartitaId partitaId) {
        return entityManager.find(Partita.class, partitaId);
    }

    @Override
    public void addPartita(Partita partita) {
        entityManager.persist(partita);
    }

    @Override
    public void updatePartita(Partita partita) {
        Partita prt = getPartitaById(partita.getNumeroAndStagione());
        prt.setNumeroAndStagione(partita.getNumeroAndStagione());
        prt.setData(partita.getData());
        prt.setMolt(partita.getMolt());
        prt.setSquadraAvversaria(partita.getSquadraAvversaria());
        entityManager.flush();
    }

    @Override
    public void deletePartita(PartitaId partitaId) {
        entityManager.remove(getPartitaById(partitaId));
    }

    @Override
    public boolean partitaExists(PartitaId partitaId) {
       /* CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Partita> q = cb.createQuery(Partita.class);
        Root<Partita> p = q.from(Partita.class);
        ParameterExpression<Integer> par = cb.parameter(Integer.class);
        q.select(p).where(cb.gt(p.get("population"), par));
*/
        String hql = "FROM Partita as p WHERE p.numeroAndStagione.stagione = ?1 AND p.numeroAndStagione.numero = ?2";
        int count = entityManager.createQuery(hql)
                .setParameter(1, partitaId.getStagione())
                .setParameter(2, partitaId.getNumero())
                .getResultList().size();
        return count > 0;
    }
}
