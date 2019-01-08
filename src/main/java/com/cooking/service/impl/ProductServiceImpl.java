package com.cooking.service.impl;

import com.cooking.dao.ProductDao;
import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    public Product getProductById(final int id) {
        return productDao.getProductById(id);
    }

    @Override
    public void addProduct(final Product productAdd) {
        productDao.addProduct(productAdd);
    }

    @Override
    public void updateProduct(final Product productUpdate) {
        productDao.updateProduct(productUpdate);
    }

    @Override
    public void deleteProduct(final Product productDelete) {
        productDao.deleteProduct(productDelete);
    }

    @Override
    public List<Product> getProductsByDish(final Dish dish) {
        return productDao.getProductsByDish(dish);
    }

    @Override
    public List<Product> getProductsByStorage(final Storage storage) {
        return productDao.getProductsByStorage(storage);
    }

    @Override
    public List<Product> getProductsByClient(final Client client) {
        return productDao.getProductsByClient(client);
    }
}
