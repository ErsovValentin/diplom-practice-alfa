package com.cooking.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "likes",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"client_id", "dish_id"})})
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private int id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id", nullable = false)
    private Dish dishLiked;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "like_date_time_create", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateAndTimeOfLike;

    public Like() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Dish getDishLiked() {
        return dishLiked;
    }

    public void setDishLiked(Dish dishLiked) {
        this.dishLiked = dishLiked;
    }

    public Date getDateAndTimeOfLike() {
        return dateAndTimeOfLike;
    }

    public void setDateAndTimeOfLike(Date dateAndTimeOfLike) {
        this.dateAndTimeOfLike = dateAndTimeOfLike;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", client=" + client.getFirstName() + " " + client.getLastName() +
                ", dishLiked=" + dishLiked.getName() +
                ", dateAndTimeOfLike=" + dateAndTimeOfLike +
                '}';
    }
}
