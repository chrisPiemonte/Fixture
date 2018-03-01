package com.database.systems.fixture.repository.repositoryInterface;

import com.database.systems.fixture.common.entity.Biglietto;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IBigliettoRepository {

    List<Biglietto> getAllBiglietti();

    Biglietto getBigliettoById(int bigliettoId);

    Biglietto addBiglietto(Biglietto biglietto);

    void updateBiglietto(Biglietto biglietto);

    void deleteBiglietto(int bigliettoId);

    boolean bigliettoExists(int bigliettoId);

}
