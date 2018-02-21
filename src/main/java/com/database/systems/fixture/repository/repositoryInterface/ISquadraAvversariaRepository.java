package com.database.systems.fixture.repository.repositoryInterface;

import com.database.systems.fixture.common.entity.SquadraAvversaria;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface ISquadraAvversariaRepository {

    List<SquadraAvversaria> getAllSquadreAvversarie();

    SquadraAvversaria getSquadraAvversariaById(String nomeSquadra);

    void addSquadraAvversaria(SquadraAvversaria squadra);

    void updateSquadraAvversaria(SquadraAvversaria squadra);

    void deleteSquadraAvversaria(String nomeSquadra);

    boolean squadraAvversariaExists(String nomeSquadra);


}
