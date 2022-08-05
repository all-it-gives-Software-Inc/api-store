package com.example.storemicroservice.controller;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

import com.example.storemicroservice.controller.response.Response;
import com.example.storemicroservice.domain.Store;
import com.example.storemicroservice.repository.StoreRepository;
import com.example.storemicroservice.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@Controller
public class StoreController {

    private final StoreRepository storeRepository; // errado, acessar pelo service

    private final StoreService storeService;

    @GetMapping("/list")
    @Operation(summary = "List all store" , description = "To use pagination and sort add the params ?page='number'&sort='field' to the url" , tags = {"store"})
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

    @PostMapping("/save")
    public ResponseEntity<Response> saveStore(@RequestBody @Valid Store store) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("StoreService", storeService.saveStore(store)))
                        .message("Store created")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());

    }

    @DeleteMapping("/delete")
    public ResponseEntity<Response> deleteStore(@RequestBody @Valid Store store) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", storeService.deleteStore(store.getId())))
                        .message("Store deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());

    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateStore(@RequestBody Store store){
         storeService.updateStore(store);
        return null;
    }


}

























