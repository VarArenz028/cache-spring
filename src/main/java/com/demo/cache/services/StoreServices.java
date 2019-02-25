package com.demo.cache.services;

import com.demo.cache.entity.Store;

import java.util.List;

/*
    @Author Var Arenz Villarino
 */
public interface StoreServices
{
    List<Store> findAllStore();

    void save(Store store);

    void resetfindAllStoreCache();

}
