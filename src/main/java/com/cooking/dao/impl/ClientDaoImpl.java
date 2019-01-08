package com.cooking.dao.impl;

import com.cooking.dao.ClientDao;
import com.cooking.model.Client;
import com.cooking.model.Comment;
import com.cooking.model.Dish;
import com.cooking.model.Storage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ClientDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public ArrayList<Client> getAllClients() {
        return (ArrayList<Client>)session()
                .createQuery("from Client",Client.class)
                .list();
    }

    @Override
    public Client getClientById(final int id) {

        return session().get(Client.class,id);
    }

    @Override
    public void addClient(final Client clientAdd) {
        session().save(clientAdd);
    }

    @Override
    public void updateClient(final Client clientUpdate) {
        session().merge(clientUpdate);
    }

    @Override
    public void deleteClient(final Client clientDelete) {
        session().delete(clientDelete);
    }

    @Override
    public List<Client> getClientsByStorage(final Storage storage) {
        return (List<Client>) session()
                .createQuery("select c from Client as c where c.storage = ?1", Client.class)
                .setParameter(1, storage)
                .list();
    }

    @Override
    public List<Client> getClientsByFavouriteDish(final Dish favouriteDish) {
        return (ArrayList<Client>)session()
                .createQuery("select f.favouriteClient from Favourite as f where f.favouriteDish = ?1", Client.class)
                .setParameter(1, favouriteDish)
                .list();
    }

    @Override
    public Client getClientByAuthoredDish(final Dish authoredDish) {
        return session()
                .createQuery("select d.authorClient from Dish as d", Client.class)
                .getSingleResult();
    }

    @Override
    public Client getClientByEmail(final String email) {
        return session()
                .createQuery("from Client as c where c.email = ?1", Client.class)
                .setParameter(1, email)
                .getSingleResult();
    }

    @Override
    public List<Client> getClientsByLikedDish(Dish dishLiked) {
        return session()
                .createQuery("select l.client from Like as l where l.dishLiked = ?1", Client.class)
                .setParameter(1, dishLiked)
                .list();
    }

    @Override
    public Client getClientByComment(Comment comment) {
        return session()
                .createQuery("select c.client from Comment as c where c = ?1", Client.class)
                .setParameter(1, comment)
                .getSingleResult();
    }

    @Override
    public List<Client> getClientsByCommentedDish(Dish dish) {
        return session()
                .createQuery("select c.client from Comment as c where c.dishCommented = ?1", Client.class)
                .setParameter(1, dish)
                .list();
    }
}
