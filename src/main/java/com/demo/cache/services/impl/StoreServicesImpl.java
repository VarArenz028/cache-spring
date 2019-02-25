package com.demo.cache.services.impl;

import com.demo.cache.entity.Store;
import com.demo.cache.repository.StoreRepository;
import com.demo.cache.services.StoreServices;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    @Author Var Arenz Villarino
 */
@Service("storeServices")
@Transactional(isolation = Isolation.READ_COMMITTED)
public class StoreServicesImpl implements StoreServices
{

    private StoreRepository storeRepository;

    public StoreServicesImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Cacheable(value = "store")
    @Override
    public List<Store> findAllStore()
    {
        return storeRepository.findAll();
    }

    @Override
    @CacheEvict(value = "store",
                beforeInvocation = true,
                allEntries = true)
    public void save(Store store)
    {
        storeRepository.save(store);
    }

    @CacheEvict(value = "store", allEntries = true)
    @Override
    public void resetfindAllStoreCache()
    {

    }
}
