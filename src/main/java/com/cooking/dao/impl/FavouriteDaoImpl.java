package com.cooking.dao.impl;

import com.cooking.dao.FavouriteDao;
import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Favourite;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
                .createQuery("from Favourite",Favourite.class)
                .list();
    }

    public Favourite getFavouriteById(int id) {
        
        return session().get(Favourite.class,id);
    }

    public void addFavourite(Favourite favouriteAdd) {
        session().save(favouriteAdd);
    }

    public void updateFavourite(Favourite favouriteUpdate) {
        session().merge(favouriteUpdate);
    }

    public void deleteFavourite(Favourite favouriteDelete) {
        session().delete(favouriteDelete);
    }

    public List<Favourite> getFavouritesByClient(Client client) {
        return (ArrayList<Favourite>)session()
                .createQuery("from Favourite where favouriteClient = ?1", Favourite.class)
                .setParameter(1, client)
                .list();
    }

    public List<Favourite> getFavouritesByDish(Dish dish) {
        return (ArrayList<Favourite>)session()
                .createQuery("from Favourite where favouriteDish = ?1", Favourite.class)
                .setParameter(1, dish)
                .list();
    }
}
