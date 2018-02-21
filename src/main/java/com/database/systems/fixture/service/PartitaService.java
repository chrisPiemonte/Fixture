package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Partita;
import com.database.systems.fixture.common.entity.composite.PartitaId;
import com.database.systems.fixture.repository.repositoryInterface.IPartitaRepository;
import com.database.systems.fixture.service.serviceInterface.IPartitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class PartitaService implements IPartitaService {

    @Autowired
    private IPartitaRepository partitaRepository;


    @Override
    public List<Partita> getAllPartite() {
        return partitaRepository.getAllPartite();
    }

    @Override
    public Partita getPartitaById(PartitaId partitaId) {
        return partitaRepository.getPartitaById(partitaId);
    }

    @Override
    public boolean addPartita(Partita partita) {
        if (partitaRepository.partitaExists(partita.getNumeroAndStagione()))
            return false;
        else {
            partitaRepository.addPartita(partita);
            return true;
        }
    }

    @Override
    public void updatePartita(Partita partita) {
        partitaRepository.updatePartita(partita);
    }

    @Override
    public void deletePartita(PartitaId partitaId) {
        partitaRepository.deletePartita(partitaId);
    }
}
