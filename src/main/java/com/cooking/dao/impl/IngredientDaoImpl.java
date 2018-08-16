package com.cooking.dao.impl;

import com.cooking.dao.IngredientDao;
import com.cooking.model.Dish;
import com.cooking.model.Ingredient;
import com.cooking.model.Product;
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

//    public Ingredient getIngredientById(int id) {
//        return session().get(Ingredient.class,id);
//    }


    public Ingredient getIngredientByDishAndProduct(Dish dish, Product product) {
       Ingredient ingredient = (Ingredient)session()
               .createQuery("select i from Ingredient i where i.ingredientDish = ?1 and i.ingredientProduct = ?2",Ingredient.class)
               .setParameter(1,dish).setParameter(2,product).getSingleResult();
        return ingredient;
    }

    public void addIngredient(Ingredient ingredientAdd) {
        session().save(ingredientAdd);
    }

    public void updateIngredient(Ingredient ingredientUpdate) {
        session().merge(ingredientUpdate);
    }

    public void deleteIngredient(Ingredient ingredientDelete) {
        session().delete(ingredientDelete);
    }
}
