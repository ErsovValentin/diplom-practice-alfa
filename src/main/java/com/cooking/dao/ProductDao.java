package com.cooking.dao;

import com.cooking.model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductDao {

    List<Product> getAllProducts();
    Product getProductById(int id);
    void addProduct(Product productAdd);
    void updateProduct(Product productUpdate);
    void deleteProduct(Product productDelete);
}
