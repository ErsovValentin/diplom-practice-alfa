package com.cooking.service;

import com.cooking.dao.StorageDao;
import com.cooking.model.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {

    @Autowired
    private StorageDao storageDao;

    public List<Storage> getAllStorages()
    {
        return storageDao.getAllStorages();
    }

    public Storage getStorageById(int storageId)
    {
        return storageDao.getStorageById(storageId);
    }

    public void addStorage(Storage storageAdd)
    {
        storageDao.addStorage(storageAdd);
    }

    public void updateStorage(Storage storageUpdate)
    {
        storageDao.updateStorage(storageUpdate);
    }

    public void deleteStorage(Storage storageDelete)
    {
        storageDao.deleteStorage(storageDelete);
    }

}
