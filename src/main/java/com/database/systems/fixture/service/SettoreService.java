package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Settore;
import com.database.systems.fixture.repository.repositoryInterface.ISettoreRepository;
import com.database.systems.fixture.service.serviceInterface.ISettoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class SettoreService implements ISettoreService {

    @Autowired
    private ISettoreRepository settoreRepository;

    @Override
    public List<Settore> getAllSettori() {
        return settoreRepository.getAllSettori();
    }

    @Override
    public Settore getSettoreById(String settoreId) {
        return settoreRepository.getSettoreById(settoreId);
    }

    @Override
    public boolean addSettore(Settore settore) {
        if (settoreRepository.settoreExists(settore.getId()))
            return false;
        else {
            settoreRepository.addSettore(settore);
            return true;
        }
    }

    @Override
    public void updateSettore(Settore settore) {
        settoreRepository.updateSettore(settore);
    }

    @Override
    public void deleteSettore(String settoreId) {
        settoreRepository.deleteSettore(settoreId);
    }
}
