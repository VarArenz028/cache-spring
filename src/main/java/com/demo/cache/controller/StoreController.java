package com.demo.cache.controller;

import com.demo.cache.entity.Store;
import com.demo.cache.repository.StoreRepository;
import com.demo.cache.services.StoreServices;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
    @Author Var Arenz Villarino
 */
@RestController
public class StoreController
{
    private StoreServices storeServices;

    public StoreController(StoreServices storeServices) {
        this.storeServices = storeServices;
    }

    @GetMapping("/stores")
    public ResponseEntity<?> findAllStore()
    {
        return ResponseEntity.ok(storeServices.findAllStore());
    }

    @PostMapping("/stores")
    public ResponseEntity<?> createStore(@RequestBody Store store)
    {
        storeServices.save(store);
        return ResponseEntity.created(null).body("Created");
    }

}
