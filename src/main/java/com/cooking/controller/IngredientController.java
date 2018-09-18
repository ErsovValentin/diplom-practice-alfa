package com.cooking.controller;

import com.cooking.controller.model.IngredientRequest;
import com.cooking.model.Dish;
import com.cooking.model.Ingredient;
import com.cooking.model.Product;
import com.cooking.service.DishService;
import com.cooking.service.IngredientService;
import com.cooking.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IngredientController {

    private static final Logger LOGGER = Logger.getLogger(IngredientController.class);

    private final IngredientService ingredientService;
    private final DishService dishService;
    private final ProductService productService;

    @Autowired
    public IngredientController(final IngredientService ingredientService,
                                final DishService dishService,
                                final ProductService productService)
    {
        this.ingredientService = ingredientService;
        this.dishService = dishService;
        this.productService = productService;
    }

    @RequestMapping("/ingredients")
    public String listOfIngredients(Model model)
    {
        model.addAttribute("ingredient", new IngredientRequest());
        model.addAttribute("listOfIngredients",ingredientService.getAllIngredients());
        model.addAttribute("listOfDishes", dishService.getAllDishes());
        model.addAttribute("listOfProducts", productService.getAllProducts());

        return "/ingredientAdmin/ingredients";
    }

    @RequestMapping(value = "ingredients/addIngredient", method = RequestMethod.POST)
    public String addIngredient (@ModelAttribute("ingredient")IngredientRequest ingredientRequest)
    {
        final Dish dish = dishService.getDishById(ingredientRequest.getDishId());
        final Product product = productService.getProductById(ingredientRequest.getProductId());

        if (!ingredientRequest.isIndicatorUpdate())
        {
            final Ingredient ingredient = ingredientRequest.toEntity(dish, product);
            ingredientService.addIngredient(ingredient);
        }
        else
        {
            final Ingredient ingredient = ingredientService.getIngredientByDishAndProduct(dish, product);
            ingredient.setIngredientDish(dish);
            ingredient.setIngredientProduct(product);
            ingredient.setQuantity(ingredientRequest.getQuantity());
            ingredientService.updateIngredient(ingredient);
        }

        return "redirect:/ingredients";
    }

    @RequestMapping(value = "/updateIngredient/{dId}/{pId}")
    public String updateIngredient(@PathVariable("dId")int dishId, @PathVariable("pId")int productId, Model model)
    {
        final Dish dish = dishService.getDishById(dishId);
        final Product product = productService.getProductById(productId);
        final Ingredient ingredient = ingredientService.getIngredientByDishAndProduct(dish, product);
        final IngredientRequest ingredientRequest = IngredientRequest.fromEntity(ingredient);
        model.addAttribute("ingredient",ingredientRequest);
        model.addAttribute("listOfIngredients",ingredientService.getAllIngredients());
        model.addAttribute("listOfDishes", dishService.getAllDishes());
        model.addAttribute("listOfProducts", productService.getAllProducts());

        return "/ingredientAdmin/ingredients";
    }

    @RequestMapping("/deleteIngredient/{dId}/{pId}")
    public String deleteIngredient(@PathVariable("dId")int dishId, @PathVariable("pId")int productId)
    {
        final Dish dish = dishService.getDishById(dishId);
        final Product product = productService.getProductById(productId);
        final Ingredient ingredient = ingredientService.getIngredientByDishAndProduct(dish, product);
        ingredientService.deleteIngredient(ingredient);
        return "redirect:/ingredients";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        LOGGER.warn("Returning HTTP 400 Bad Request", e);
    }
}
