package com.database.systems.fixture.service.serviceInterface;

import com.database.systems.fixture.common.entity.Partita;
import com.database.systems.fixture.common.entity.composite.PartitaId;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IPartitaService {

    List<Partita> getAllPartite();

    Partita getPartitaById(PartitaId partitaId);

    boolean addPartita(Partita partita);

    void updatePartita(Partita partita);

    void deletePartita(PartitaId partitaId);

}
