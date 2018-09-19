package com.cooking.controller.model;

import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Favourite;

public class FavouriteRequest {

    private int id;
    private int userId;
    private int dishId;

    public FavouriteRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public Favourite toEntity(final Client client, final Dish dish)
    {
        final Favourite favourite = new Favourite();
        favourite.setId(id);
        favourite.setFavouriteUser(client);
        favourite.setFavouriteDish(dish);
        return favourite;
    }

    public static FavouriteRequest fromEntity(final Favourite favourite)
    {
        final FavouriteRequest favouriteRequest = new FavouriteRequest();
        favouriteRequest.setId(favourite.getId());
        favouriteRequest.setUserId(favourite.getFavouriteUser().getId());
        favouriteRequest.setDishId(favourite.getFavouriteDish().getId());
        return favouriteRequest;
    }
}
