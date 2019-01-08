package com.cooking.dao.impl;

import com.cooking.dao.DishDao;
import com.cooking.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Dish> getDishesByProduct(Product product) {
        return (ArrayList<Dish>)session()
                .createQuery("select i.ingredientDish from Ingredient i where i.ingredientProduct = ?1", Dish.class)
                .setParameter(1, product)
                .list();
    }

    public ArrayList<Dish> getFavouriteDishesByClient(Client client) {
        return (ArrayList<Dish>)session()
                .createQuery("select f.favouriteDish from Favourite f where f.favouriteClient = ?1", Dish.class)
                .setParameter(1, client)
                .list();
    }

    public ArrayList<Dish> getDishesByStorage(Storage storage) {
        return (ArrayList<Dish>)session()
                .createQuery("select i.ingredientDish from Ingredient as i inner join i.ingredientProduct as p inner join p.storageProducts as sp where sp.storage = ?1", Dish.class)
                .setParameter(1, storage)
                .list();
    }

    public ArrayList<Dish> getDishesByClient(Client client) {
        return (ArrayList<Dish>)session()
                .createQuery("select i.ingredientDish from Ingredient as i inner join i.ingredientProduct as p inner join p.storageProducts as sp inner join sp.storage as s where ?1 in elements(s.clients)", Dish.class)
                .setParameter(1, client)
                .list();
    }

    @Override
    public ArrayList<Dish> getDishesByTimeOfCooking(float timeOfCooking) {
        return (ArrayList<Dish>) session()
                .createQuery("from Dish as d where d.timeOfCooking <= ?1", Dish.class)
                .setParameter(1, timeOfCooking)
                .list();
    }

    @Override
    public ArrayList<Dish> getDishesByLikeClient(Client client) {
        return (ArrayList<Dish>) session()
                .createQuery("select l.dishLiked from Like as l where l.client = ?1", Dish.class)
                .setParameter(1, client)
                .list();
    }

    @Override
    public Dish getDishByComment(Comment comment) {
        return session()
                .createQuery("select c.dishCommented from Comment as c where c = ?1", Dish.class)
                .setParameter(1, comment)
                .getSingleResult();
    }

    @Override
    public List<Dish> getCommentedDishesByClient(Client client) {
        return session()
                .createQuery("select c.dishCommented from Comment as c where c.client = ?1", Dish.class)
                .setParameter(1, client)
                .list();
    }

    @Override
    public Dish getDishByRecipeStep(RecipeStep recipeStep) {
        return session()
                .createQuery("select rs.dish from RecipeStep as rs where rs = ?1", Dish.class)
                .setParameter(1, recipeStep)
                .getSingleResult();
    }
}
