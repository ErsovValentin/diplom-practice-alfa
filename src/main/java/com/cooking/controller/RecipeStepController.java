package com.cooking.controller;

import com.cooking.model.Dish;
import com.cooking.model.RecipeStep;
import com.cooking.service.DishService;
import com.cooking.service.RecipeStepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeStepController {

    private final RecipeStepService recipeStepService;
    private final DishService dishService;

    public RecipeStepController(RecipeStepService recipeStepService,
                                DishService dishService) {
        this.recipeStepService = recipeStepService;
        this.dishService = dishService;
    }

    @GetMapping("/recipe-steps")
    public ResponseEntity<List<RecipeStep>> getAllRecipeSteps(){
        final List<RecipeStep> recipeSteps = recipeStepService.getAllRecipeSteps();
        return new ResponseEntity<>(recipeSteps, HttpStatus.OK);
    }

    @GetMapping("/recipe-steps/{id}")
    public ResponseEntity<RecipeStep> getRecipeStepById(@PathVariable int id){
        final RecipeStep recipeStep = recipeStepService.getRecipeStepById(id);
        return new ResponseEntity<>(recipeStep, HttpStatus.OK);
    }

    @PostMapping("/recipe-steps")
    public ResponseEntity<RecipeStep> addRecipeStep(@RequestBody RecipeStep recipeStep){
        recipeStepService.addRecipeStep(recipeStep);
        return new ResponseEntity<>(recipeStep, HttpStatus.OK);
    }

    @PutMapping("/recipe-steps")
    public ResponseEntity<RecipeStep> updateRecipeStep(@RequestBody RecipeStep recipeStep){
        recipeStepService.updateRecipeStep(recipeStep);
        return new ResponseEntity<>(recipeStep, HttpStatus.OK);
    }

    @DeleteMapping("/recipe-steps/{id}")
    public ResponseEntity<RecipeStep> deleteRecipeStep(@PathVariable int id){
        final RecipeStep recipeStep = recipeStepService.getRecipeStepById(id);
        recipeStepService.deleteRecipeStep(recipeStep);
        return new ResponseEntity<>(recipeStep, HttpStatus.OK);
    }

    @GetMapping("/recipe-steps/dish/{id}")
    public ResponseEntity<List<RecipeStep>> getRecipeStepsByDish(@PathVariable int id){
        final Dish dish = dishService.getDishById(id);
        final List<RecipeStep> recipeSteps = recipeStepService.getRecipeStepsByDish(dish);
        return new ResponseEntity<>(recipeSteps, HttpStatus.OK);
    }
}
