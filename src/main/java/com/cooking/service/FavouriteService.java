package com.cooking.service;

import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Favourite;

import java.util.ArrayList;
import java.util.List;

public interface FavouriteService {

    ArrayList<Favourite> getAllFavourites();
    Favourite getFavouriteById(int id);
    void addFavourite(Favourite favouriteAdd);
    void updateFavoutite(Favourite favouriteUpdate);
    void deleteFavourite(Favourite favouriteDelete);
    List<Favourite> getFavouritesByClient(Client client);
    List<Favourite> getFavouritesByDish(Dish dish);
}
