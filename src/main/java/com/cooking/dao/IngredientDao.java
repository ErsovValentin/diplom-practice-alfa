package com.cooking.dao;

import com.cooking.model.Dish;
import com.cooking.model.Ingredient;
import com.cooking.model.Product;

import java.util.ArrayList;

public interface IngredientDao {

    ArrayList<Ingredient> getAllIngredients();
    Ingredient getIngredientById(int id);
    Ingredient getIngredientByDishAndProduct(Dish dish, Product product);
    void addIngredient(Ingredient ingredientAdd);
    void updateIngredient(Ingredient ingredientUpdate);
    void deleteIngredient(Ingredient ingredientDelete);
}
