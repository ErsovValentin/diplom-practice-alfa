package com.cooking.model;

import com.cooking.model.addition.DishType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "dish")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int id;

    @Column(name = "dish_name",length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "dish_type", nullable = false)
    private DishType type;

    @Column(name = "dish_description",columnDefinition = "text")
    private String description;

    @Column(name = "dish_time_cooking", nullable = false)
    private float timeOfCooking;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "dish_date_create", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateOfCreate;

    @Lob
    @Column(name = "dish_image")
    private byte[] image;

    @OneToMany(mappedBy = "ingredientDish",cascade = CascadeType.ALL)
    private Set<Ingredient> ingredients;

    @OneToMany(mappedBy = "favouriteDish",cascade = CascadeType.ALL)
    private Set<Favourite>favourites;

    @OneToMany(mappedBy = "dishLiked",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Like> like;

    @OneToMany(mappedBy = "dishCommented",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "dish",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RecipeStep> recipeSteps;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client authorClient;

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

    public float getTimeOfCooking() {
        return timeOfCooking;
    }

    public void setTimeOfCooking(float timeOfCooking) {
        this.timeOfCooking = timeOfCooking;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public Set<Like> getLike() {
        return like;
    }

    public void setLike(Set<Like> like) {
        this.like = like;
    }

    public Client getAuthorClient() {
        return authorClient;
    }

    public void setAuthorClient(Client authorClient) {
        this.authorClient = authorClient;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", timeOfCooking=" + timeOfCooking +
                ", dateOfCreate=" + dateOfCreate +
                ", authorClient=" + authorClient.getFirstName() + " " + authorClient.getLastName() +
                '}';
    }
}
