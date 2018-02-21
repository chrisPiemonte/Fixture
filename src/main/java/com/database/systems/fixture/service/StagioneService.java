package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Stagione;
import com.database.systems.fixture.repository.IStagioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class StagioneService implements IStagioneService{

    @Autowired
    private IStagioneRepository stagioneRepository;

    @Override
    public List<Stagione> getAllStagioni() {
        return stagioneRepository.getAllStagioni();
    }

    @Override
    public Stagione getStagioneById(int stagioneId) {
        return null;
    }

    @Override
    public boolean addAStagione(Stagione stagione) {
        return false;
    }

    @Override
    public void updateStagione(Stagione stagione) {

    }

    @Override
    public void deleteStagione(int stagioneId) {

    }


}
