package com.cooking.controller;

import com.cooking.model.Client;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.service.ClientService;
import com.cooking.service.ProductService;
import com.cooking.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StorageController {

    private final StorageService storageService;
    private final ClientService clientService;
    private final ProductService productService;

    public StorageController(StorageService storageService,
                             ClientService clientService,
                             ProductService productService) {
        this.storageService = storageService;
        this.clientService = clientService;
        this.productService = productService;
    }

    @GetMapping("/storages")
    public ResponseEntity<List<Storage>> getAllStorages(){
        final List<Storage> storages = storageService.getAllStorages();
        return new ResponseEntity<>(storages, HttpStatus.OK);
    }

    @GetMapping("/storages/{id}")
    public ResponseEntity<Storage> getStorageById(@PathVariable int id){
        final Storage storage = storageService.getStorageById(id);
        return new ResponseEntity<>(storage, HttpStatus.OK);
    }

    @PostMapping("/storages")
    public ResponseEntity<Storage> addStorage(@RequestBody Storage storage){
        storageService.addStorage(storage);
        return new ResponseEntity<>(storage, HttpStatus.OK);
    }

    @PutMapping("/storages")
    public ResponseEntity<Storage> updateStorage(@RequestBody Storage storage){
        storageService.updateStorage(storage);
        return new ResponseEntity<>(storage, HttpStatus.OK);
    }

    @DeleteMapping("/storages/{id}")
    public ResponseEntity<Storage> deleteStorage(@PathVariable int id){
        final Storage storage = storageService.getStorageById(id);
        storageService.deleteStorage(storage);
        return new ResponseEntity<>(storage, HttpStatus.OK);
    }

    @GetMapping("/storages/client/{id}")
    public ResponseEntity<Storage> getStorageByClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        final Storage storage = storageService.getStorageByClient(client);
        return new ResponseEntity<>(storage, HttpStatus.OK);
    }

    @GetMapping("/storages/product/{id}")
    public ResponseEntity<List<Storage>> getStoragesByProduct(@PathVariable int id){
        final Product product = productService.getProductById(id);
        final List<Storage> storages = storageService.getStoragesByProduct(product);
        return new ResponseEntity<>(storages, HttpStatus.OK);
    }
}
