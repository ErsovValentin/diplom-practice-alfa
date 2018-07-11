package com.cooking.dao;

import com.cooking.model.Storage;

import java.util.ArrayList;

public interface StorageDao {

    ArrayList<Storage> getAllStorages();
    Storage getStorageById(int id);
    void addStorage(Storage storageAdd);
    void updateStorage(Storage storageUpdate);
    void deleteStorage(Storage storageDelete);
}
