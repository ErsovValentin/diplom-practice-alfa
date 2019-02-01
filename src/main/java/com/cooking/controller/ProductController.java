package com.cooking.controller;

import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.service.ClientService;
import com.cooking.service.DishService;
import com.cooking.service.ProductService;
import com.cooking.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;
    private final DishService dishService;
    private final StorageService storageService;
    private final ClientService clientService;

    public ProductController(ProductService productService,
                             DishService dishService,
                             StorageService storageService,
                             ClientService clientService) {
        this.productService = productService;
        this.dishService = dishService;
        this.storageService = storageService;
        this.clientService = clientService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        final List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        final Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int id){
        final Product product = productService.getProductById(id);
        productService.deleteProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products/dish/{id}")
    public ResponseEntity<List<Product>> getProductsByDish(@PathVariable int id){
        final Dish dish = dishService.getDishById(id);
        final List<Product> products = productService.getProductsByDish(dish);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/storage/{id}")
    public ResponseEntity<List<Product>> getProductsByStorage(@PathVariable int id){
        final Storage storage = storageService.getStorageById(id);
        final List<Product> products = productService.getProductsByStorage(storage);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/client/{id}")
    public ResponseEntity<List<Product>> getProductsByClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        final List<Product> products = productService.getProductsByClient(client);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
