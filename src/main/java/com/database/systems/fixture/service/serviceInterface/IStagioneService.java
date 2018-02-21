package com.database.systems.fixture.service.serviceInterface;

import com.database.systems.fixture.common.entity.Stagione;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IStagioneService {

    List<Stagione> getAllStagioni();

    Stagione getStagioneById(String stagioneId);

    boolean addStagione(Stagione stagione);

    void updateStagione(Stagione stagione);

    void deleteStagione(String stagioneId);

}
