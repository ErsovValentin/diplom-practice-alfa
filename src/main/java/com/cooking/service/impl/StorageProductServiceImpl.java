package com.cooking.service.impl;

import com.cooking.dao.StorageProductDao;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.StorageProduct;
import com.cooking.service.StorageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageProductServiceImpl implements StorageProductService {

    @Autowired
    private final StorageProductDao storageProductDao;

    public StorageProductServiceImpl(StorageProductDao storageProductDao) {
        this.storageProductDao = storageProductDao;
    }

    @Override
    public List<StorageProduct> getAllStorageProducts() {
        return storageProductDao.getAllStorageProducts();
    }

    @Override
    public StorageProduct getStorageProductsById(int id) {
        return storageProductDao.getStorageProductsById(id);
    }

    @Override
    public StorageProduct getStorageProducts(final Storage storage, final Product product) {
        return storageProductDao.getStorageProducts(storage, product);
    }

    @Override
    public void addStorageProducts(final StorageProduct storageProductAdd) {
        storageProductDao.addStorageProducts(storageProductAdd);
    }

    @Override
    public void updateStorageProducts(final StorageProduct storageProductUpdate) {
        storageProductDao.updateStorageProducts(storageProductUpdate);
    }

    @Override
    public void deleteStorageProducts(final StorageProduct storageProductDelete) {
        storageProductDao.deleteStorageProducts(storageProductDelete);
    }
}
