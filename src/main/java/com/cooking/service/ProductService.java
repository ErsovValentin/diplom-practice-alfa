package com.cooking.service;

import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Product;
import com.cooking.model.Storage;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product productAdd);
    void updateProduct(Product productUpdate);
    void deleteProduct(Product productDelete);
    List<Product> getProductsByDish(Dish dish);
    List<Product> getProductsByStorage(Storage storage);
    List<Product> getProductsByClient(Client client);

}
