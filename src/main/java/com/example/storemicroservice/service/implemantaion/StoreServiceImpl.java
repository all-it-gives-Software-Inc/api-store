package com.example.storemicroservice.service.implemantaion;

import com.example.storemicroservice.domain.Store;
import com.example.storemicroservice.repository.StoreRepository;
import com.example.storemicroservice.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    @Override
    public Page<Store> listAll(Pageable pageable) {
        log.info("Listing all stores");
        return storeRepository.findAll(pageable);
    }
    @Override
    public Store save(Store store) {
        log.info("Saving new store: {}", store.getName());
        return storeRepository.save(store);
    }
    @Override
    public void update(Store store) {
        log.info("Updating store: {}", store.getName());
        storeRepository.save(store);
    }

    @Override
    public Boolean delete(Integer id) {
        log.info("Deleting store: {}", storeRepository.findById(id));
        storeRepository.deleteById(id);
        return Boolean.TRUE;
    }


}
