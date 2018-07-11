package com.cooking.dao.impl;

import com.cooking.dao.DishDao;
import com.cooking.model.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class DishDaoImpl implements DishDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public DishDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }


    public ArrayList<Dish> getAllDishes() {
        
        return (ArrayList<Dish>)session()
                .createQuery("select d from Dish d",Dish.class)
                .list();
    }

    public Dish getDishById(int id) {
        return session().get(Dish.class,id);
    }

    public void addDish(Dish dishAdd) {
        session().save(dishAdd);
    }

    public void updateDish(Dish dishUpdate) {
        session().merge(dishUpdate);
    }

    public void deleteDish(Dish dishDelete) {
        session().delete(dishDelete);
    }
}
