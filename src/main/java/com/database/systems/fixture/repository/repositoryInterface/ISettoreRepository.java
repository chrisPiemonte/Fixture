package com.database.systems.fixture.repository.repositoryInterface;

import com.database.systems.fixture.common.entity.Settore;

import java.util.List;

/**
 * Created by chris on 2/21/18.
 */
public interface ISettoreRepository {

    List<Settore> getAllSettori();

    Settore getSettoreById(String settoreId);

    void addSettore(Settore settore);

    void updateSettore(Settore settore);

    void deleteSettore(String settoreId);

    boolean settoreExists(String settoreId);

}
