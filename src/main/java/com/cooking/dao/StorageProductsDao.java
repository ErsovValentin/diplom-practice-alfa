package com.cooking.dao;

import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.StorageProducts;

import java.util.List;

public interface StorageProductsDao {

    public List<StorageProducts> getAllStorageProducts();
    public StorageProducts getStorageProductsById(int id);
    public StorageProducts getStorageProducts(Storage storage, Product product);
    public void addStorageProducts(StorageProducts storageProductsAdd);
    public void updateStorageProducts(StorageProducts storageProductsUpdate);
    public void deleteStorageProducts(StorageProducts storageProductsDelete);
}
