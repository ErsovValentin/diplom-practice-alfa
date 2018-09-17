package com.cooking.dao.impl;

import com.cooking.dao.StorageDao;
import com.cooking.model.Storage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

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



    public ArrayList<Storage> getAllStorages() {

        return (ArrayList<Storage>)session()
                .createQuery("from Storage",Storage.class)
                .list();
    }

    public Storage getStorageById(int id) {

        return session().get(Storage.class,id);
    }

    /*public Storage getStorageByIdProductClient(int id, Product product, Client client) {
        Storage storage = (Storage) session()
                .createQuery("select s from Storage s where s.id = ?1 and s.storageProduct = ?2 and storageUser = ?3", Storage.class)
                .setParameter(1,id)
                .setParameter(2, product)
                .setParameter(3, client)
                .getSingleResult();
        return storage;
    }*/

    public void addStorage(Storage storageAdd) {
        session().save(storageAdd);
    }

    public void updateStorage(Storage storageUpdate) {
        session().merge(storageUpdate);
    }

    public void deleteStorage(Storage storageDelete) {
        session().delete(storageDelete);
    }
}
