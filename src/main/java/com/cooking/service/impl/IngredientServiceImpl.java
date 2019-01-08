package com.cooking.service.impl;

import com.cooking.dao.IngredientDao;
import com.cooking.model.Dish;
import com.cooking.model.Ingredient;
import com.cooking.model.Product;
import com.cooking.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private final IngredientDao ingredientDao;

    public IngredientServiceImpl(final IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    @Override
    public ArrayList<Ingredient> getAllIngredients() {
        return ingredientDao.getAllIngredients();
    }

    @Override
    public Ingredient getIngredientByDishAndProduct(final Dish dish, final Product product) {
        return ingredientDao.getIngredientByDishAndProduct(dish, product);
    }

    @Override
    public void addIngredient(final Ingredient ingredientAdd) {
        ingredientDao.addIngredient(ingredientAdd);
    }

    @Override
    public void updateIngredient(final Ingredient ingredientUpdate) {
        ingredientDao.updateIngredient(ingredientUpdate);
    }

    @Override
    public void deleteIngredient(final Ingredient ingredientDelete) {
        ingredientDao.deleteIngredient(ingredientDelete);
    }
}
