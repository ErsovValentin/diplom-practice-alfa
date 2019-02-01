package com.cooking.service;

import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.StorageProduct;

import java.util.List;

public interface StorageProductService {

    public List<StorageProduct> getAllStorageProducts();
    public StorageProduct getStorageProductsById(int id);
    public StorageProduct getStorageProducts(Storage storage, Product product);
    public void addStorageProducts(StorageProduct storageProductAdd);
    public void updateStorageProducts(StorageProduct storageProductUpdate);
    public void deleteStorageProducts(StorageProduct storageProductDelete);
}
