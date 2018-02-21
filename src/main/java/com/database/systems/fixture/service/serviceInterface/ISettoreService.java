package com.database.systems.fixture.service.serviceInterface;

import com.database.systems.fixture.common.entity.Settore;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface ISettoreService {

    List<Settore> getAllSettori();

    Settore getSettoreById(String settoreId);

    boolean addSettore(Settore settore);

    void updateSettore(Settore settore);

    void deleteSettore(String settoreId);

}
