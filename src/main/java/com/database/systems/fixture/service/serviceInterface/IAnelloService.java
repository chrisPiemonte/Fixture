package com.database.systems.fixture.service.serviceInterface;

import com.database.systems.fixture.common.entity.Anello;
import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface IAnelloService {

    List<Anello> getAllAnelli();

    Anello getAnelloById(String anelloId);

    boolean addAnello(Anello anello);

    void updateAnello(Anello anello);

    void deleteAnello(String anelloId);

}
