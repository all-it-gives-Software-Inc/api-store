package com.example.storemicroservice.service;

import com.example.storemicroservice.domain.Store;
import com.example.storemicroservice.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public Page<Store> listAll(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }

    public Store save(Store store){
        return storeRepository.save(store);
    }

    public void update(Store store) {
         storeRepository.save(store);
    }
}
