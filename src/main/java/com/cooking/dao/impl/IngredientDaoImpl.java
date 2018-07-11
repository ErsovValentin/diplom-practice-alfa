package com.cooking.dao.impl;

import com.cooking.dao.IngredientDao;
import com.cooking.model.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class IngredientDaoImpl implements IngredientDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public IngredientDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }


    public ArrayList<Ingredient> getAllIngredients() {

        return (ArrayList<Ingredient>)session()
                .createQuery("select i from Ingredient i",Ingredient.class)
                .list();
    }

    public Ingredient getIngredientById(int id) {
        return session().get(Ingredient.class,id);
    }

    public void addIngredient(Ingredient ingredientAdd) {
        session().save(ingredientAdd);
    }

    public void updateIngredient(Ingredient ingredientUpdate) {
        session().merge(ingredientUpdate);
    }

    public void deleteIngredient(Ingredient ingredientDelete) {
        session().merge(ingredientDelete);
    }
}
