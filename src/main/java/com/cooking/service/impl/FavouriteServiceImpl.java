package com.cooking.service.impl;

import com.cooking.dao.FavouriteDao;
import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Favourite;
import com.cooking.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private final FavouriteDao favouriteDao;

    public FavouriteServiceImpl(FavouriteDao favouriteDao) {
        this.favouriteDao = favouriteDao;
    }

    @Override
    public ArrayList<Favourite> getAllFavourites() {
        return favouriteDao.getAllFavourites();
    }

    @Override
    public Favourite getFavouriteById(final int id) {
        return favouriteDao.getFavouriteById(id);
    }

    @Override
    public void addFavourite(final Favourite favouriteAdd) {
        favouriteDao.addFavourite(favouriteAdd);
    }

    @Override
    public void updateFavourite(final Favourite favouriteUpdate) {
        favouriteDao.updateFavourite(favouriteUpdate);
    }

    @Override
    public void deleteFavourite(final Favourite favouriteDelete) {
        favouriteDao.deleteFavourite(favouriteDelete);
    }

    @Override
    public List<Favourite> getFavouritesByClient(final Client client) {
        return favouriteDao.getFavouritesByClient(client);
    }

    @Override
    public List<Favourite> getFavouritesByDish(final Dish dish) {
        return favouriteDao.getFavouritesByDish(dish);
    }
}
