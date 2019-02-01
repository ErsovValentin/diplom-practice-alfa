package com.cooking.service.impl;

import com.cooking.dao.DishDao;
import com.cooking.model.*;
import com.cooking.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private final DishDao dishDao;

    public DishServiceImpl(final DishDao dishDao) {
        this.dishDao = dishDao;
    }

    @Override
    public ArrayList<Dish> getAllDishes() {
        return dishDao.getAllDishes();
    }

    @Override
    public Dish getDishById(final int id) {
        return dishDao.getDishById(id);
    }

    @Override
    public void addDish(final Dish dishAdd) {
        dishDao.addDish(dishAdd);
    }

    @Override
    public void updateDish(final Dish dishUpdate) {
        dishDao.updateDish(dishUpdate);
    }

    @Override
    public void deleteDish(final Dish dishDelete) {
        dishDao.deleteDish(dishDelete);
    }

    @Override
    public List<Dish> getDishesByProduct(final Product product) {
        return dishDao.getDishesByProduct(product);
    }

    @Override
    public List<Dish> getFavouriteDishesByClient(final Client client) {
        return dishDao.getFavouriteDishesByClient(client);
    }

    @Override
    public List<Dish> getDishesByStorage(final Storage storage) {
        return dishDao.getDishesByStorage(storage);
    }

    @Override
    public List<Dish> getDishesByClient(final Client client) {
        return dishDao.getDishesByClient(client);
    }

    @Override
    public List<Dish> getDishesByTimeOfCooking(float timeOfCooking) {
        return dishDao.getDishesByTimeOfCooking(timeOfCooking);
    }

    @Override
    public List<Dish> getDishesByLikeClient(Client client) {
        return dishDao.getDishesByLikeClient(client);
    }

    @Override
    public Dish getDishByComment(Comment comment) {
        return dishDao.getDishByComment(comment);
    }

    @Override
    public List<Dish> getCommentedDishesByClient(Client client) {
        return dishDao.getCommentedDishesByClient(client);
    }

    @Override
    public Dish getDishByRecipeStep(RecipeStep recipeStep) {
        return dishDao.getDishByRecipeStep(recipeStep);
    }
}
