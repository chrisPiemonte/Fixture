package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Anello;
import com.database.systems.fixture.repository.repositoryInterface.IAnelloRepository;
import com.database.systems.fixture.repository.repositoryInterface.IStagioneRepository;
import com.database.systems.fixture.service.serviceInterface.IAnelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class AnelloService implements IAnelloService {

    @Autowired
    private IAnelloRepository anelloRepository;

    @Override
    public List<Anello> getAllAnelli() {
        return anelloRepository.getAllAnelli();
    }

    @Override
    public Anello getAnelloById(String anelloId) {
        return anelloRepository.getAnelloById(anelloId);
    }

    @Override
    public boolean addAnello(Anello anello) {
        if (anelloRepository.anelloExists(anello.getId())) {
            return false;
        } else {
            anelloRepository.addAnello(anello);
            return true;
        }
    }

    @Override
    public void updateAnello(Anello anello) {
        anelloRepository.updateAnello(anello);
    }

    @Override
    public void deleteAnello(String anelloId) {
        anelloRepository.deleteAnello(anelloId);
    }
}
