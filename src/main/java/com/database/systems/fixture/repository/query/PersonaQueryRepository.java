package com.database.systems.fixture.repository.query;

import com.database.systems.fixture.common.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chris on 2/23/18.
 */

@Repository
public interface PersonaQueryRepository extends JpaRepository<Persona, Integer> {

    @Query( "SELECT p " +
            "FROM Persona p, Biglietto b " +
            "WHERE p.cf = b.spettatore AND b.partita=:partita AND b.stagione=:stagione AND b.settore=:settore")
    List<Persona> getPersoneFromPartitaSettore(@Param("partita") int partita,
                                               @Param("settore") String settore,
                                               @Param("stagione") String stagione);

}
