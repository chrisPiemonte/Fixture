package com.database.systems.fixture.repository.repositoryInterface;

import com.database.systems.fixture.common.entity.Posto;
import com.database.systems.fixture.common.entity.composite.PostoId;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IPostoRepository {

    List<Posto> getAllPosti();

    Posto getPostoById(PostoId postoId);

    void addPosto(Posto posto);

    void updatePosto(Posto posto);

    void deletePosto(PostoId postoId);

    boolean postoExists(PostoId postoId);

}
