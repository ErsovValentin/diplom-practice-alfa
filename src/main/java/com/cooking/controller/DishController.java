package com.cooking.controller;

import com.cooking.model.*;
import com.cooking.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DishController {

    private final DishService dishService;
    private final ProductService productService;
    private final StorageService storageService;
    private final ClientService clientService;
    private final CommentService commentService;
    private final RecipeStepService recipeStepService;

    public DishController(DishService dishService,
                          ProductService productService,
                          StorageService storageService,
                          ClientService clientService,
                          CommentService commentService,
                          RecipeStepService recipeStepService) {
        this.dishService = dishService;
        this.productService = productService;
        this.storageService = storageService;
        this.clientService = clientService;
        this.commentService = commentService;
        this.recipeStepService = recipeStepService;
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> getAllDishes(){
        final List<Dish> dishes = dishService.getAllDishes();
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dishes/{id}")
    public ResponseEntity<Dish> getDishById(@PathVariable int id){
        final Dish dish = dishService.getDishById(id);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @PostMapping("/dishes")
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish){
        dishService.addDish(dish);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @PutMapping("/dishes")
    public ResponseEntity<Dish> updateDish(@RequestBody Dish dish){
        dishService.updateDish(dish);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @DeleteMapping("/dishes/{id}")
    public ResponseEntity<Dish> deleteDish(@PathVariable int id){
        final Dish dish = dishService.getDishById(id);
        dishService.deleteDish(dish);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @GetMapping("/dishes/product/{id}")
    public ResponseEntity<List<Dish>> getDishesByProduct(@PathVariable int id){
        final Product product = productService.getProductById(id);
        final List<Dish> dishes = dishService.getDishesByProduct(product);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dishes/favourite-client/{id}")
    public ResponseEntity<List<Dish>> getFavouriteDishesByClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        final List<Dish> dishes = dishService.getFavouriteDishesByClient(client);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dishes/storage/{id}")
    public ResponseEntity<List<Dish>> getDishesByStorage(@PathVariable int id){
        final Storage storage = storageService.getStorageById(id);
        final List<Dish> dishes = dishService.getDishesByStorage(storage);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dishes/client/{id}")
    public ResponseEntity<List<Dish>> getDishesByClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        final List<Dish> dishes = dishService.getDishesByClient(client);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dishes/cooking-time")
    public ResponseEntity<List<Dish>> getDishesByTimeOfCooking(@RequestBody float timeOfCooking){
        final List<Dish> dishes = dishService.getDishesByTimeOfCooking(timeOfCooking);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dishes/like-client/{id}")
    public ResponseEntity<List<Dish>> getDishesByLikeClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        final List<Dish> dishes = dishService.getDishesByLikeClient(client);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dishes/comment/{id}")
    public ResponseEntity<Dish> getDishByComment(@PathVariable int id){
        final Comment comment = commentService.getCommentById(id);
        final Dish dish = dishService.getDishByComment(comment);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }

    @GetMapping("/dishes/comment-client/{id}")
    public ResponseEntity<List<Dish>> getCommentedDishesByClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        final List<Dish> dishes = dishService.getCommentedDishesByClient(client);
        return new ResponseEntity<>(dishes, HttpStatus.OK);
    }

    @GetMapping("/dishes/recipe-step/{id}")
    public ResponseEntity<Dish> getDishByRecipeStep(@PathVariable int id){
        final RecipeStep recipeStep = recipeStepService.getRecipeStepById(id);
        final Dish dish = dishService.getDishByRecipeStep(recipeStep);
        return new ResponseEntity<>(dish, HttpStatus.OK);
    }
}
