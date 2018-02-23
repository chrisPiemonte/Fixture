package com.database.systems.fixture.repository.query;

import com.database.systems.fixture.common.entity.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chris on 2/23/18.
 */

@Repository
public interface BigliettoQueryRepository extends JpaRepository<Biglietto, Integer> {

    @Query( "SELECT b " +
            "FROM Biglietto b " +
            "WHERE b.partita=:partita AND b.stagione=:stagione" +
            " AND b.posto=:posto AND b.settore=:settore AND b.anello=:anello")
    List<Biglietto> isPostoOccupato(@Param("partita") int partita, @Param("stagione") String stagione,
                                    @Param("posto") int posto, @Param("settore") String settore,
                                    @Param("anello") String anello);
}
