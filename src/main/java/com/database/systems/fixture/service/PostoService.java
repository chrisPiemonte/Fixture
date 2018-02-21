package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Posto;
import com.database.systems.fixture.common.entity.composite.PostoId;
import com.database.systems.fixture.repository.repositoryInterface.IPostoRepository;
import com.database.systems.fixture.service.serviceInterface.IPostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class PostoService implements IPostoService {

    @Autowired
    private IPostoRepository postoRepository;

    @Override
    public List<Posto> getAllPosti() {
        return postoRepository.getAllPosti();
    }

    @Override
    public Posto getPostoById(PostoId postoId) {
        return postoRepository.getPostoById(postoId);
    }

    @Override
    public boolean addPosto(Posto posto) {
        if (postoRepository.postoExists(posto.getNumeroSettoreAnello()))
            return false;
        else {
            postoRepository.addPosto(posto);
            return true;
        }
    }

    @Override
    public void updatePosto(Posto posto) {
        postoRepository.updatePosto(posto);
    }

    @Override
    public void deletePosto(PostoId postoId) {
        postoRepository.deletePosto(postoId);
    }

}
