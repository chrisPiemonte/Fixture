package com.database.systems.fixture.service;

import com.database.systems.fixture.common.entity.Biglietto;
import com.database.systems.fixture.repository.repositoryInterface.IBigliettoRepository;
import com.database.systems.fixture.service.serviceInterface.IBigliettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */

@Service
public class BigliettoService implements IBigliettoService {

    @Autowired
    private IBigliettoRepository bigliettoRepository;

    @Override
    public List<Biglietto> getAllBiglietti() {
        return bigliettoRepository.getAllBiglietti();
    }

    @Override
    public Biglietto getBigliettoById(int bigliettoId) {
        return bigliettoRepository.getBigliettoById(bigliettoId);
    }

    @Override
    public Biglietto addBiglietto(Biglietto biglietto) {
        return bigliettoRepository.addBiglietto(biglietto);
        /*if (bigliettoRepository.bigliettoExists(biglietto.getId()))
            return false;
        else {
            b = bigliettoRepository.addBiglietto(biglietto);
            return true;
        }*/

    }

    @Override
    public void updateBiglietto(Biglietto biglietto) {
        bigliettoRepository.updateBiglietto(biglietto);
    }

    @Override
    public void deleteBiglietto(int bigliettoId) {
        bigliettoRepository.deleteBiglietto(bigliettoId);
    }
}
