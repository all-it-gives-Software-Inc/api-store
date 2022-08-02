package com.example.storemicroservice.service;

import com.example.storemicroservice.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreService {

     Page<Store> listAll(Pageable pageable);
     Store save(Store store);
     void update(Store store);
}
