package com.cooking.model;

import javax.persistence.*;

@Entity
@Table(name = "favourite",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"client_id", "dish_id"})})
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favourite_id")
    private int id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client favouriteClient;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish favouriteDish;

    public Favourite() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getFavouriteClient() {
        return favouriteClient;
    }

    public void setFavouriteClient(Client favouriteClient) {
        this.favouriteClient = favouriteClient;
    }

    public Dish getFavouriteDish() {
        return favouriteDish;
    }

    public void setFavouriteDish(Dish favouriteDish) {
        this.favouriteDish = favouriteDish;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "id=" + id +
                ", favouriteUser=" + favouriteClient.getFirstName()+ " " +favouriteClient.getLastName()+
                ", favouriteDish=" + favouriteDish.getName() +
                '}';
    }
}
