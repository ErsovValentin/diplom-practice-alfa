package com.cooking.model;


import com.cooking.model.addition.ProductMeasure;
import com.cooking.model.addition.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private int id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false)
    private ProductType type;

    @Column(name = "product_description",columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_measure", nullable = false)
    private ProductMeasure measure;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredientProduct",cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;

    @JsonIgnore
    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Set<StorageProduct> storageProducts;

    public Product() {
    }

    public ProductMeasure getMeasure() {
        return measure;
    }

    public void setMeasure(ProductMeasure measure) {
        this.measure = measure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<StorageProduct> getStorageProducts() {
        return storageProducts;
    }

    public void setStorageProducts(Set<StorageProduct> storageProducts) {
        this.storageProducts = storageProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", measure=" + measure +
                '}';
    }
}
