package com.cooking.service;

import com.cooking.dao.ProductDao;
import com.cooking.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public List<Product> getAllProducts()
    {
        return productDao.getAllProducts();
    }

    public Product getProductById(int productId)
    {
        return productDao.getProductById(productId);
    }

    public void addProduct(Product productAdd)
    {
        productDao.addProduct(productAdd);
    }

    public void updateProduct(Product productUpdate)
    {
        productDao.updateProduct(productUpdate);
    }

    public void deleteProduct(Product productDelete)
    {
        productDao.deleteProduct(productDelete);
    }

}
