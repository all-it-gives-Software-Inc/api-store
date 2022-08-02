package com.example.storemicroservice.controller;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

import com.example.storemicroservice.controller.response.Response;
import com.example.storemicroservice.domain.Store;
import com.example.storemicroservice.repository.StoreRepository;
import com.example.storemicroservice.service.StoreService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
@Slf4j
@RequiredArgsConstructor
public class StoreController {

    private final StoreRepository storeRepository; // errado, acessar pelo service

    private final StoreService storeService;

    @GetMapping("/list")
    public ResponseEntity<Response> listAllStore(Pageable pageable) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("StoreService", storeService.listAll(pageable)))
                        .message("Store retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<Store> save(@RequestBody @Valid Store store) {
        return ResponseEntity.ok(storeService.save(store));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody Store store){
         storeService.update(store);
        return null;
    }


}

























