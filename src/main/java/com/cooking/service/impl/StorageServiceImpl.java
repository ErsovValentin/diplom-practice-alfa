package com.cooking.service.impl;

import com.cooking.dao.StorageDao;
import com.cooking.model.Client;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private final StorageDao storageDao;

    public StorageServiceImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public ArrayList<Storage> getAllStorages() {
        return storageDao.getAllStorages();
    }

    @Override
    public Storage getStorageById(final int id) {
        return storageDao.getStorageById(id);
    }

    @Override
    public void addStorage(final Storage storageAdd) {
        storageDao.addStorage(storageAdd);
    }

    @Override
    public void updateStorage(final Storage storageUpdate) {
        storageDao.updateStorage(storageUpdate);
    }

    @Override
    public void deleteStorage(final Storage storageDelete) {
        storageDao.deleteStorage(storageDelete);
    }

    @Override
    public Storage getStorageByClient(final Client client) {
        return storageDao.getStorageByClient(client);
    }

    @Override
    public List<Storage> getStoragesByProduct(final Product product) {
        return storageDao.getStoragesByProduct(product);
    }
}
