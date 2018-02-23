package com.database.systems.fixture.repository.query;

import com.database.systems.fixture.common.entity.bean.Stats;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by chris on 2/23/18.
 */

@Transactional
@Repository
public class QueryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public QueryRepository() {
    }


    @SuppressWarnings("unchecked")
    public List<Stats> getStatsStagione(String stagione) {

        Query query = entityManager.createNativeQuery(
                "SELECT  b.partita, b.settore, COUNT(b.posto) " +
                "FROM Biglietto b " +
                "WHERE b.stagione = ? " +
                "GROUP BY (b.partita, b.settore) " +
                "ORDER BY (b.partita, b.settore)");
        query.setParameter(1, stagione);
        // List result = query.getResultList();
        List<Stats> list = query.getResultList();

        return list;

    }


}
