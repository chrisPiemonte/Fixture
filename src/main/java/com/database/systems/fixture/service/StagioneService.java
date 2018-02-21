package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Stagione;
import com.database.systems.fixture.repository.repositoryInterface.IStagioneRepository;
import com.database.systems.fixture.service.serviceInterface.IStagioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class StagioneService implements IStagioneService {

    @Autowired
    private IStagioneRepository stagioneRepository;

    @Override
    public List<Stagione> getAllStagioni() {
        return stagioneRepository.getAllStagioni();
    }

    @Override
    public Stagione getStagioneById(String stagioneId) {
        return stagioneRepository.getStagioneById(stagioneId);
    }

    @Override
    public boolean addStagione(Stagione stagione) {
        if (stagioneRepository.stagioneExists(stagione.getAnno()))
            return false;
        else {
            stagioneRepository.addStagione(stagione);
            return true;
        }
    }

    @Override
    public void updateStagione(Stagione stagione) {
        stagioneRepository.updateStagione(stagione);
    }

    @Override
    public void deleteStagione(String stagioneId) {
        stagioneRepository.deleteStagione(stagioneId);
    }


}
