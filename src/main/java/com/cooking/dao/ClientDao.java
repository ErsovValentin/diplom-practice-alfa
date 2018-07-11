package com.cooking.dao;

import com.cooking.model.Client;

import java.util.ArrayList;

public interface ClientDao {

    ArrayList<Client> getAllClients();
    Client getClientById(int id);
    void addClient(Client userAdd);
    void updateClient(Client userUpdate);
    void deleteClient(Client userDelete);
}
