package com.cooking.dao.impl;

import com.cooking.dao.FavouriteDao;
import com.cooking.model.Favourite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public class FavouriteDaoImpl implements FavouriteDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public FavouriteDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    public ArrayList<Favourite> getAllFavourites() {
        
        return (ArrayList<Favourite>)session()
                .createQuery("select f from Favourite f",Favourite.class)
                .list();
    }

    public Favourite getFavouriteById(int id) {
        
        return session().get(Favourite.class,id);
    }

    public void addFavourite(Favourite favouriteAdd) {
        session().save(favouriteAdd);
    }

    public void updateFavoutite(Favourite favouriteUpdate) {
        session().merge(favouriteUpdate);
    }

    public void deleteFavourite(Favourite favouriteDelete) {
        session().delete(favouriteDelete);
    }
}
