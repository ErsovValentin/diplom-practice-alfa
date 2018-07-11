package com.cooking.dao;

import com.cooking.model.Favourite;

import java.util.ArrayList;

public interface FavouriteDao {

    ArrayList<Favourite> getAllFavourites();
    Favourite getFavouriteById(int id);
    void addFavourite(Favourite favouriteAdd);
    void updateFavoutite(Favourite favouriteUpdate);
    void deleteFavourite(Favourite favouriteDelete);
}
