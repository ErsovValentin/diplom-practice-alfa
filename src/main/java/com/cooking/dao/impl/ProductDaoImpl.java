package com.cooking.dao.impl;

import com.cooking.dao.ProductDao;
import com.cooking.model.Client;
import com.cooking.model.Dish;
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

    public List<Product> getProductsByDish(Dish dish) {
        return (ArrayList<Product>) session()
                .createQuery("select i.ingredientProduct from Ingredient i where i.ingredientDish = ?1 ",Product.class)
                .setParameter(1, dish)
                .list();
    }

    public List<Product> getProductsByStorage(Storage storage) {
        return (ArrayList<Product>) session()
                .createQuery("select sp.product from StorageProduct as sp where sp.storage = ?1 ",Product.class)
                .setParameter(1, storage)
                .list();
    }

    public List<Product> getProductsByClient(Client client) {
        return (ArrayList<Product>) session()
                .createQuery("select sp.product from StorageProduct as sp inner join sp.storage as s where ?1 in elements(s.clients) ",Product.class)
                .setParameter(1, client)
                .list();
    }
}
