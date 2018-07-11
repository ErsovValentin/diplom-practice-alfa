package com.cooking.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish ingredientDish;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product ingredientProduct;

    @Column(name = "ingredient_quantity")
    private float quantity;

    public Ingredient() {
    }

    public Dish getIngredientDish() {
        return ingredientDish;
    }

    public void setIngredientDish(Dish ingredientDish) {
        this.ingredientDish = ingredientDish;
    }

    public Product getIngredientProduct() {
        return ingredientProduct;
    }

    public void setIngredientProduct(Product ingredientProduct) {
        this.ingredientProduct = ingredientProduct;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientDish=" + ingredientDish.getName() +
                ", ingredientProduct=" + ingredientProduct.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
