package com.cooking.dao;

import com.cooking.model.Client;
import com.cooking.model.Product;
import com.cooking.model.Storage;

import java.util.ArrayList;
import java.util.List;

public interface StorageDao {

    ArrayList<Storage> getAllStorages();
    Storage getStorageById(int id);
    void addStorage(Storage storageAdd);
    void updateStorage(Storage storageUpdate);
    void deleteStorage(Storage storageDelete);
    Storage getStorageByClient(Client client);
    List<Storage> getStoragesByProduct(Product product);
}
