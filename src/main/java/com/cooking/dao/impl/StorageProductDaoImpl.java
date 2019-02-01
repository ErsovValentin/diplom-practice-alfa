package com.cooking.dao.impl;

import com.cooking.dao.StorageProductDao;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.StorageProduct;
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
public class StorageProductDaoImpl implements StorageProductDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public StorageProductDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }


    public List<StorageProduct> getAllStorageProducts() {
        return (ArrayList<StorageProduct>) session()
                .createQuery("from StorageProduct", StorageProduct.class)
                .list();
    }

    @Override
    public StorageProduct getStorageProductsById(int id) {
        return session().get(StorageProduct.class, id);
    }

    public StorageProduct getStorageProducts(Storage storage, Product product) {
        return (StorageProduct)session()
                .createQuery("from StorageProduct sp where sp.storage = ?1 and sp.product = ?2", StorageProduct.class)
                .setParameter(1,storage)
                .setParameter(2,product)
                .getSingleResult();
    }

    public void addStorageProducts(StorageProduct storageProductAdd) {
        session()
                .save(storageProductAdd);
    }

    public void updateStorageProducts(StorageProduct storageProductUpdate) {
        session()
                .merge(storageProductUpdate);
    }

    public void deleteStorageProducts(StorageProduct storageProductDelete) {
        session()
                .delete(storageProductDelete);
    }
}
