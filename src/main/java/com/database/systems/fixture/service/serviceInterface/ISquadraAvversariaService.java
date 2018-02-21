package com.database.systems.fixture.service.serviceInterface;

import com.database.systems.fixture.common.entity.SquadraAvversaria;
import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface ISquadraAvversariaService {

    List<SquadraAvversaria> getAllSquadreAvversarie();

    SquadraAvversaria getSquadraAvversariaById(String nome);

    boolean addSquadraAvversaria(SquadraAvversaria squadraAvversaria);

    void updateSquadraAvversaria(SquadraAvversaria squadraAvversaria);

    void deleteSquadraAvversaria(String nome);

}
