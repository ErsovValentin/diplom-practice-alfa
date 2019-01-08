package com.cooking.service.impl;

import com.cooking.dao.StorageProductsDao;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.StorageProducts;
import com.cooking.service.StorageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageProductServiceImpl implements StorageProductService {

    @Autowired
    private final StorageProductsDao storageProductsDao;

    public StorageProductServiceImpl(StorageProductsDao storageProductsDao) {
        this.storageProductsDao = storageProductsDao;
    }

    @Override
    public List<StorageProducts> getAllStorageProducts() {
        return storageProductsDao.getAllStorageProducts();
    }

    @Override
    public StorageProducts getStorageProducts(final Storage storage, final Product product) {
        return storageProductsDao.getStorageProducts(storage, product);
    }

    @Override
    public void addStorageProducts(final StorageProducts storageProductsAdd) {
        storageProductsDao.addStorageProducts(storageProductsAdd);
    }

    @Override
    public void updateStorageProducts(final StorageProducts storageProductsUpdate) {
        storageProductsDao.updateStorageProducts(storageProductsUpdate);
    }

    @Override
    public void deleteStorageProducts(final StorageProducts storageProductsDelete) {
        storageProductsDao.deleteStorageProducts(storageProductsDelete);
    }
}
