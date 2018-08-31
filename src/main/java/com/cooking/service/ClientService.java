package com.cooking.service;

import com.cooking.dao.ClientDao;
import com.cooking.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public List<Client> getAllCliets()
    {
        return clientDao.getAllClients();
    }

    public Client getClientById(int clientId)
    {
        return clientDao.getClientById(clientId);
    }

    public void addClient(Client clientAdd)
    {
        clientDao.addClient(clientAdd);
    }

    public void updateClient(Client clientUpdate)
    {
        clientDao.updateClient(clientUpdate);
    }

    public void deleteClient(Client clientDelete)
    {
        clientDao.deleteClient(clientDelete);
    }
}
