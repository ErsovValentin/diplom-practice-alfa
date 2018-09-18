package com.cooking.controller.model;

import com.cooking.model.Dish;
import com.cooking.model.Ingredient;
import com.cooking.model.Product;

public class IngredientRequest {

    private int dishId;

    private int productId;

    private float quantity;

    // new == false //update == true
    private boolean indicatorUpdate;

    public IngredientRequest() {
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public boolean isIndicatorUpdate() {
        return indicatorUpdate;
    }

    public void setIndicatorUpdate(boolean indicatorUpdate) {
        this.indicatorUpdate = indicatorUpdate;
    }

    public Ingredient toEntity(final Dish dish, final Product product)
    {
        final Ingredient ingredient = new Ingredient();
        ingredient.setQuantity(quantity);
        ingredient.setIngredientDish(dish);
        ingredient.setIngredientProduct(product);
        return ingredient;
    }

    public static IngredientRequest fromEntity(final Ingredient ingredient)
    {
        final IngredientRequest ingredientRequest = new IngredientRequest();
        ingredientRequest.setDishId(ingredient.getIngredientDish().getId());
        ingredientRequest.setProductId(ingredient.getIngredientProduct().getId());
        ingredient.setQuantity(ingredient.getQuantity());
        ingredientRequest.setIndicatorUpdate(true);

        return ingredientRequest;
    }
}
