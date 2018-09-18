package com.cooking.service;


import com.cooking.dao.IngredientDao;
import com.cooking.model.Dish;
import com.cooking.model.Ingredient;
import com.cooking.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientDao ingredientDao;

    public List<Ingredient> getAllIngredients ()
    {
        return ingredientDao.getAllIngredients();
    }

    public Ingredient getIngredientByDishAndProduct (Dish dish, Product product)
    {
        return ingredientDao.getIngredientByDishAndProduct(dish, product);
    }

    public void addIngredient(Ingredient ingredientAdd)
    {
        ingredientDao.addIngredient(ingredientAdd);
    }

    public void updateIngredient(Ingredient ingredientUpdate)
    {
        ingredientDao.updateIngredient(ingredientUpdate);
    }

    public void deleteIngredient (Ingredient ingredientDelete)
    {
        ingredientDao.deleteIngredient(ingredientDelete);
    }
}
