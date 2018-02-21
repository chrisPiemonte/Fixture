package com.database.systems.fixture.repository;

import com.database.systems.fixture.common.entity.Stagione;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

public interface IStagioneRepository {

    List<Stagione> getAllStagioni();

    Stagione getStagioneById(int stagioneId);

    void addStagione(Stagione stagione);

    void updateStagione(Stagione stagione);

    void deleteStagione(int Stagione);

    boolean StagioneExists(String anno);

}
