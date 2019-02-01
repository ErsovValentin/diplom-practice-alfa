package com.cooking.service.impl;

import com.cooking.dao.RecipeStepDao;
import com.cooking.model.Dish;
import com.cooking.model.RecipeStep;
import com.cooking.service.RecipeStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeStepServiceImpl implements RecipeStepService {

    @Autowired
    private final RecipeStepDao recipeStepDao;

    public RecipeStepServiceImpl(RecipeStepDao recipeStepDao) {
        this.recipeStepDao = recipeStepDao;
    }

    @Override
    public List<RecipeStep> getAllRecipeSteps() {
        return recipeStepDao.getAllRecipeSteps();
    }

    @Override
    public RecipeStep getRecipeStepById(int id) {
        return recipeStepDao.getRecipeStepById(id);
    }

    @Override
    public void addRecipeStep(RecipeStep recipeStepAdd) {
        recipeStepDao.addRecipeStep(recipeStepAdd);
    }

    @Override
    public void updateRecipeStep(RecipeStep recipeStepUpdate) {
        recipeStepDao.updateRecipeStep(recipeStepUpdate);
    }

    @Override
    public void deleteRecipeStep(RecipeStep recipeStepDelete) {
        recipeStepDao.deleteRecipeStep(recipeStepDelete);
    }

    @Override
    public List<RecipeStep> getRecipeStepsByDish(Dish dish) {
        return recipeStepDao.getRecipeStepsByDish(dish);
    }
}
