package com.database.systems.fixture.repository.repositoryInterface;

import com.database.systems.fixture.common.entity.Partita;
import com.database.systems.fixture.common.entity.composite.PartitaId;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IPartitaRepository {

    List<Partita> getAllPartite();

    Partita getPartitaById(PartitaId partitaId);

    void addPartita(Partita partita);

    void updatePartita(Partita partita);

    void deletePartita(PartitaId partitaId);

    boolean partitaExists(PartitaId partitaId);


}
