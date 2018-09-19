package com.cooking.service;


import com.cooking.dao.FavouriteDao;
import com.cooking.model.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteService {

    @Autowired
    private FavouriteDao favouriteDao;

    public List<Favourite> getAllFavourites()
    {
        return favouriteDao.getAllFavourites();
    }

    public Favourite getFavouriteById(int favouriteId)
    {
        return favouriteDao.getFavouriteById(favouriteId);
    }

    public void addFavourite (Favourite favouriteAdd)
    {
        favouriteDao.addFavourite(favouriteAdd);
    }

    public void updateFavourite (Favourite favouriteUpdate)
    {
        favouriteDao.updateFavoutite(favouriteUpdate);
    }

    public void deleteFavourite (Favourite favouriteDelete)
    {
        favouriteDao.deleteFavourite(favouriteDelete);
    }
}
