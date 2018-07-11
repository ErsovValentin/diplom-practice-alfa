package com.cooking.dao;

import com.cooking.model.Ingredient;

import java.util.ArrayList;

public interface IngredientDao {

    ArrayList<Ingredient> getAllIngredients();
    Ingredient getIngredientById(int id);
    void addIngredient(Ingredient ingredientAdd);
    void updateIngredient(Ingredient ingredientUpdate);
    void deleteIngredient(Ingredient ingredientDelete);
}
