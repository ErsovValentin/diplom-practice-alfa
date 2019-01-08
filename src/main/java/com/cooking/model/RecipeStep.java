package com.cooking.model;

import javax.persistence.*;

@Entity
@Table(name = "recepie_step",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"recepie_step_number", "dish_id"})})
public class RecipeStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recepie_step_id")
    private int id;

    @Column(name = "recepie_step_number", nullable = false)
    private int numberOfStep;

    @Column(name = "recepie_step_description", columnDefinition = "text", nullable = false)
    private String description;

    @Lob
    @Column(name = "recepie_step_image")
    private byte[] image;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dish;

    public RecipeStep() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfStep() {
        return numberOfStep;
    }

    public void setNumberOfStep(int numberOfStep) {
        this.numberOfStep = numberOfStep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "RecipeStep{" +
                "id=" + id +
                ", numberOfStep=" + numberOfStep +
                ", description='" + description + '\'' +
                ", dish=" + dish.getName() +
                '}';
    }
}
