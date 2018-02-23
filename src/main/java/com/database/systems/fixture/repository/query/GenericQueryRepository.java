package com.database.systems.fixture.repository.query;

import com.database.systems.fixture.common.entity.bean.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by chris on 2/23/18.
 */
/*
@Repository
@Transactional*/
public interface GenericQueryRepository {


    // SELECT b.partita, b.settore, COUNT(b.posto)
    // FROM Biglietto b
    // WHERE stagione = '0001'
    // GROUP BY (partita, settore)
    // ORDER BY (partita, settore)

    // SELECT new Map(b.partita as partita, b.settore as settore, COUNT(b.posto) as count)
    // FROM Biglietto b
    // WHERE b.stagione = '0001'
    // GROUP BY (partita, settore)
    // ORDER BY (partita, settore)

   /* @Query( value =
            "SELECT NEW com.database.systems.fixture.common.entity.bean.Stats(b.partita, b.settore, COUNT(b.posto)) " +
            "FROM Biglietto b " +
            "WHERE b.stagione = :stagione " +
            "GROUP BY (b.partita, b.settore) " +
            "ORDER BY (b.partita, b.settore)")
    List<Stats> getStatsStagione(@Param("stagione") String stagione);*/





}
