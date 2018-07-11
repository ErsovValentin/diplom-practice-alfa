package com.cooking.model;

import javax.persistence.*;

@Entity
@Table(name = "favourite")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "favourite_id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Client favouriteUser;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish favouriteDish;

    public Favourite() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getFavouriteUser() {
        return favouriteUser;
    }

    public void setFavouriteUser(Client favouriteUser) {
        this.favouriteUser = favouriteUser;
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
                ", favouriteUser=" + favouriteUser.getFirstName()+ " " +favouriteUser.getLastName()+
                ", favouriteDish=" + favouriteDish.getName() +
                '}';
    }
}
