package com.cooking.service.impl;

import com.cooking.dao.ClientDao;
import com.cooking.model.Client;
import com.cooking.model.Comment;
import com.cooking.model.Dish;
import com.cooking.model.Storage;
import com.cooking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientDao clientDao;

    public ClientServiceImpl(final ClientDao clientDao) {
        this.clientDao = clientDao;
    }


    @Override
    public ArrayList<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    @Override
    public Client getClientById(int id) {
        return clientDao.getClientById(id);
    }

    @Override
    public void addClient(Client clientAdd) {
        clientDao.addClient(clientAdd);
    }

    @Override
    public void updateClient(Client clientUpdate) {
        clientDao.updateClient(clientUpdate);
    }

    @Override
    public void deleteClient(Client clientDelete) {
        clientDao.deleteClient(clientDelete);
    }

    @Override
    public List<Client> getClientsByStorage(Storage storage) {
        return clientDao.getClientsByStorage(storage);
    }

    @Override
    public List<Client> getClientsByFavouriteDish(Dish favouriteDish) {
        return clientDao.getClientsByFavouriteDish(favouriteDish);
    }

    @Override
    public Client getClientByAuthoredDish(Dish authoredDish) {
        return clientDao.getClientByAuthoredDish(authoredDish);
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientDao.getClientByEmail(email);
    }

    @Override
    public List<Client> getClientsByLikedDish(Dish dishLiked) {
        return clientDao.getClientsByLikedDish(dishLiked);
    }

    @Override
    public Client getClientByComment(Comment comment) {
        return clientDao.getClientByComment(comment);
    }

    @Override
    public List<Client> getClientsByCommentedDish(Dish dish) {
        return clientDao.getClientsByCommentedDish(dish);
    }
}
