package com.cooking.dao;

import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.StorageProduct;

import java.util.List;

public interface StorageProductDao {

    List<StorageProduct> getAllStorageProducts();
    StorageProduct getStorageProductsById(int id);
    StorageProduct getStorageProducts(Storage storage, Product product);
    void addStorageProducts(StorageProduct storageProductAdd);
    void updateStorageProducts(StorageProduct storageProductUpdate);
    void deleteStorageProducts(StorageProduct storageProductDelete);
}
