package com.demo.cache.repository;

import com.demo.cache.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    @Author Var Arenz Villarino
 */
public interface StoreRepository extends JpaRepository<Store, Integer>
{
}
