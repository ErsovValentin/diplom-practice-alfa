package com.cooking.controller;

import com.cooking.model.Dish;
import com.cooking.model.Ingredient;
import com.cooking.model.Product;
import com.cooking.service.DishService;
import com.cooking.service.IngredientService;
import com.cooking.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final DishService dishService;
    private final ProductService productService;

    public IngredientController(IngredientService ingredientService,
                                DishService dishService,
                                ProductService productService) {
        this.ingredientService = ingredientService;
        this.dishService = dishService;
        this.productService = productService;
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingredient>> getAllIngredients(){
        final List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable int id){
        final Ingredient ingredient = ingredientService.getIngredientById(id);
        return new ResponseEntity<>(ingredient,HttpStatus.OK);
    }

    @PostMapping("/ingredients")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }

    @PutMapping("/ingredients")
    public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient ingredient){
        ingredientService.updateIngredient(ingredient);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }

    @DeleteMapping("/ingredients/{id}")
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable int id){
        final Ingredient ingredient = ingredientService.getIngredientById(id);
        ingredientService.deleteIngredient(ingredient);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }

    @GetMapping("/ingredients/dish/{dishId}/product/{productId}")
    public ResponseEntity<Ingredient> getIngredientByDishAndProduct(@PathVariable("dishId") int dishId, @PathVariable("productId") int productId){
        final Dish dish = dishService.getDishById(dishId);
        final Product product = productService.getProductById(productId);
        final Ingredient ingredient = ingredientService.getIngredientByDishAndProduct(dish, product);
        return new ResponseEntity<>(ingredient, HttpStatus.OK);
    }
}
