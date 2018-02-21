package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.SquadraAvversaria;
import com.database.systems.fixture.repository.repositoryInterface.ISquadraAvversariaRepository;
import com.database.systems.fixture.service.serviceInterface.ISquadraAvversariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class SquadraAvversariaService implements ISquadraAvversariaService {

    @Autowired
    private ISquadraAvversariaRepository squadraAvversariaRepository;

    @Override
    public List<SquadraAvversaria> getAllSquadreAvversarie() {
        return squadraAvversariaRepository.getAllSquadreAvversarie();
    }

    @Override
    public SquadraAvversaria getSquadraAvversariaById(String nome) {
        return squadraAvversariaRepository.getSquadraAvversariaById(nome);
    }

    @Override
    public boolean addSquadraAvversaria(SquadraAvversaria squadraAvversaria) {
        if (squadraAvversariaRepository.squadraAvversariaExists(squadraAvversaria.getNome()))
            return false;
        else {
            squadraAvversariaRepository.addSquadraAvversaria(squadraAvversaria);
            return true;
        }
    }

    @Override
    public void updateSquadraAvversaria(SquadraAvversaria squadraAvversaria) {
        squadraAvversariaRepository.updateSquadraAvversaria(squadraAvversaria);
    }

    @Override
    public void deleteSquadraAvversaria(String nome) {
        squadraAvversariaRepository.deleteSquadraAvversaria(nome);
    }
}
