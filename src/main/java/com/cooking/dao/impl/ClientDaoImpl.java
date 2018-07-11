package com.cooking.dao.impl;

import com.cooking.dao.ClientDao;
import com.cooking.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

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



    public ArrayList<Client> getAllClients() {

        return (ArrayList<Client>)session()
                .createQuery("from Client",Client.class)
                .list();
    }

    public Client getClientById(int id) {

        return session().get(Client.class,id);
    }

    public void addClient(Client userAdd) {
        session().save(userAdd);
    }

    public void updateClient(Client userUpdate) {
        session().merge(userUpdate);
    }

    public void deleteClient(Client userDelete) {
        session().delete(userDelete);
    }


}
