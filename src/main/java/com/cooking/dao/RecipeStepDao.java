package com.cooking.dao;

import com.cooking.model.Dish;
import com.cooking.model.RecipeStep;

import java.util.List;

public interface RecipeStepDao {

    List<RecipeStep> getAllRecipeSteps();
    RecipeStep getRecipeStepById(int id);
    void addRecipeStep(RecipeStep recipeStepAdd);
    void updateRecipeStep(RecipeStep recipeStepUpdate);
    void deleteRecipeStep(RecipeStep recipeStepDelete);
    List<RecipeStep> getRecipeStepsByDish(Dish dish);

}
