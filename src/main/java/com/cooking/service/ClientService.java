package com.cooking.service;


import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Storage;

import java.util.ArrayList;
import java.util.List;

public interface ClientService {

    ArrayList<Client> getAllClients();
    Client getClientById(int id);
    void addClient(Client clientAdd);
    void updateClient(Client clientUpdate);
    void deleteClient(Client clientDelete);
    List<Client> getClientsByStorage(Storage storage);
    List<Client> getClientsByFavouriteDish(Dish favouriteDish);
}
