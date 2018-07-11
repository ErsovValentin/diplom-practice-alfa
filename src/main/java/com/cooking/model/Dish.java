package com.cooking.model;

import com.cooking.model.addition.DishType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "dish")
public class Dish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dish_id")
    private int id;

    @Column(name = "dish_name",length = 255)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_type")
    private DishType type;

    @Column(name = "dish_description",columnDefinition = "text")
    private String description;

    @Column(name = "dish_recepie",columnDefinition = "text")
    private String recepie;

    @OneToMany(mappedBy = "ingredientDish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ingredient> ingredients;

    @OneToMany(mappedBy = "favouriteDish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Favourite>favourites;

    public Dish() {
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

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRecepie() {
        return recepie;
    }

    public void setRecepie(String recepie) {
        this.recepie = recepie;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Favourite> getFavourites() {
        return favourites;
    }

    public void setFavourites(Set<Favourite> favourites) {
        this.favourites = favourites;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", recepie='" + recepie + '\'' +
                '}';
    }
}
