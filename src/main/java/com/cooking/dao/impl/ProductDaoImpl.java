package com.cooking.dao.impl;

import com.cooking.dao.ProductDao;
import com.cooking.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }



    public ArrayList<Product> getAllProducts() {
        return (ArrayList<Product>) session()
                .createQuery("from Product p ",Product.class)
                .list();
    }

    public Product getProductById(int id) {
        return session().get(Product.class,id);
    }

    public void addProduct(Product productAdd) {
        session().save(productAdd);
    }

    public void updateProduct(Product productUpdate) {
        session().merge(productUpdate);
    }

    public void deleteProduct(Product productDelete) {
        session().delete(productDelete);
    }
}
