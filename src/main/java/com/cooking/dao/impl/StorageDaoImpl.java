package com.cooking.dao.impl;

import com.cooking.dao.StorageDao;
import com.cooking.model.Client;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StorageDaoImpl implements StorageDao {


    private final SessionFactory sessionFactory;

    @Autowired
    public StorageDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    public Storage getStorageById(int id) {
        return (Storage) session()
                .get(Storage.class, id);
    }

    public ArrayList<Storage> getAllStorages() {

        return (ArrayList<Storage>)session()
                .createQuery("from Storage",Storage.class)
                .list();
    }

    public void addStorage(Storage storageAdd) {
        session().save(storageAdd);
    }

    public void updateStorage(Storage storageUpdate) {
        session().merge(storageUpdate);
    }

    public void deleteStorage(Storage storageDelete) {
        session().delete(storageDelete);
    }

    public Storage getStorageByClient(Client client) {
        return  (Storage) session()
                .createQuery("select c.storage from Client c where c.id = ?1",Storage.class)
                .setParameter(1,client.getId())
                .getSingleResult();
    }

    public List<Storage> getStoragesByProduct(Product product) {
        return (ArrayList<Storage>)session()
                .createQuery("select sp.storage from StorageProduct sp where sp.product = ?1", Storage.class)
                .setParameter(1, product)
                .list();
    }
}
