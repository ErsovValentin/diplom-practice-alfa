package com.cooking.dao.impl;

import com.cooking.dao.StorageProductsDao;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.StorageProducts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


//    Test!!!!


@Repository
@Transactional
public class StorageProductsDaoImpl implements StorageProductsDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public StorageProductsDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }


    public List<StorageProducts> getAllStorageProducts() {
        return (ArrayList<StorageProducts>) session()
                .createQuery("from StorageProducts", StorageProducts.class)
                .list();
    }

    @Override
    public StorageProducts getStorageProductsById(int id) {
        return session().get(StorageProducts.class, id);
    }

    public StorageProducts getStorageProducts(Storage storage, Product product) {
        return (StorageProducts)session()
                .createQuery("from StorageProducts sp where sp.storage = ?1 and sp.product = ?2", StorageProducts.class)
                .setParameter(1,storage)
                .setParameter(2,product)
                .getSingleResult();
    }

    public void addStorageProducts(StorageProducts storageProductsAdd) {
        session()
                .save(storageProductsAdd);
    }

    public void updateStorageProducts(StorageProducts storageProductsUpdate) {
        session()
                .merge(storageProductsUpdate);
    }

    public void deleteStorageProducts(StorageProducts storageProductsDelete) {
        session()
                .delete(storageProductsDelete);
    }
}
