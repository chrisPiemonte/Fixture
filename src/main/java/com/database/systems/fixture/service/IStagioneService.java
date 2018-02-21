package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Stagione;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IStagioneService {

    List<Stagione> getAllStagioni();
    Stagione getStagioneById(int stagioneId);
    boolean addAStagione(Stagione stagione);
    void updateStagione(Stagione stagione);
    void deleteStagione(int stagioneId);

}
