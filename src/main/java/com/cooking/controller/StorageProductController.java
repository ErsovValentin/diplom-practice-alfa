package com.cooking.controller;

import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.StorageProduct;
import com.cooking.service.ProductService;
import com.cooking.service.StorageProductService;
import com.cooking.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StorageProductController {

    private final StorageProductService storageProductService;
    private final StorageService storageService;
    private final ProductService productService;

    public StorageProductController(StorageProductService storageProductService,
                                    StorageService storageService,
                                    ProductService productService) {
        this.storageProductService = storageProductService;
        this.storageService = storageService;
        this.productService = productService;
    }

    @GetMapping("/storage-products")
    public ResponseEntity<List<StorageProduct>> getAllStorageProducts(){
        final List<StorageProduct> storageProducts = storageProductService.getAllStorageProducts();
        return new ResponseEntity<>(storageProducts, HttpStatus.OK);
    }

    @GetMapping("/storage-products/{id}")
    public ResponseEntity<StorageProduct> getStorageProductsById(@PathVariable int id){
        final StorageProduct storageProduct = storageProductService.getStorageProductsById(id);
        return new ResponseEntity<>(storageProduct, HttpStatus.OK);
    }

    @PostMapping("/storage-products")
    public ResponseEntity<StorageProduct> getStorageProductsById(@RequestBody StorageProduct storageProduct){
        storageProductService.addStorageProducts(storageProduct);
        return new ResponseEntity<>(storageProduct, HttpStatus.OK);
    }

    @PutMapping("/storage-products")
    public ResponseEntity<StorageProduct> updateStorageProducts(@RequestBody StorageProduct storageProduct){
        storageProductService.updateStorageProducts(storageProduct);
        return new ResponseEntity<>(storageProduct, HttpStatus.OK);
    }

    @DeleteMapping("/storage-products/{id}")
    public ResponseEntity<StorageProduct> deleteStorageProducts(@PathVariable int id){
        final StorageProduct storageProduct = storageProductService.getStorageProductsById(id);
        storageProductService.deleteStorageProducts(storageProduct);
        return new ResponseEntity<>(storageProduct, HttpStatus.OK);
    }

    @GetMapping("/storage-products/storage/{storageId}/product/{productId}")
    public ResponseEntity<StorageProduct> getStorageProducts(@PathVariable("storageId") int storageId, @PathVariable("productId") int productId){
        final Storage storage = storageService.getStorageById(storageId);
        final Product product = productService.getProductById(productId);
        final StorageProduct storageProduct = storageProductService.getStorageProducts(storage, product);
        return new ResponseEntity<>(storageProduct, HttpStatus.OK);
    }
}
