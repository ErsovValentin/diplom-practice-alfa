package com.cooking.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ingredient",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"dish_id", "product_id"})})
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private int id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish ingredientDish;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product ingredientProduct;

    @Column(name = "ingredient_quantity", nullable = false)
    private float quantity;

    public Ingredient() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", ingredientDish=" + ingredientDish.getName() +
                ", ingredientProduct=" + ingredientProduct.getName() +
                ", quantity=" + quantity +
                '}';
    }
}
