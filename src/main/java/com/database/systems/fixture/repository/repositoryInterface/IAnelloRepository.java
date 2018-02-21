package com.database.systems.fixture.repository.repositoryInterface;

import com.database.systems.fixture.common.entity.Anello;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IAnelloRepository {

    List<Anello> getAllAnelli();

    Anello getAnelloById(String anelloId);

    void addAnello(Anello anello);

    void updateAnello(Anello anello);

    void deleteAnello(String anelloId);

    boolean anelloExists(String anelloId);

}
