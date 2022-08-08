package com.example.storemicroservice.service.implemantaion;

import com.example.storemicroservice.domain.Store;
import com.example.storemicroservice.repository.StoreRepository;
import com.example.storemicroservice.service.StoreService;
import com.example.storemicroservice.util.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final Utils utils;

    private final StoreRepository storeRepository;
    @Override
    public Page<Store> listAll(Pageable pageable) {
        log.info("Listing all stores");
        return storeRepository.findAll(pageable);
    }
    @Override
    public Store saveStore(Store store) {
        log.info("Saving new store: {}", store.getName());
        return storeRepository.save(store);
    }
    @Override
    public void updateStore(Store store) {
        log.info("Updating store: {}", store.getName());
        storeRepository.save(store);
    }

    @Override
    public Boolean deleteStore(Long id) {
        log.info("Deleting store: {}", storeRepository.findById(id));
        storeRepository.delete(utils.findAnimeOrThrowNotFound(id, storeRepository));
        return Boolean.TRUE;
    }


}
