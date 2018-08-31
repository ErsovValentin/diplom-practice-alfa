package com.cooking.controller;

import com.cooking.model.Client;
import com.cooking.model.addition.UserRole;
import com.cooking.model.addition.UserSex;
import com.cooking.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping( value = "/clients")
    public String listOfClients(Model model, ModelAndView modelAndView)
    {
        model.addAttribute("listOfClients", clientService.getAllCliets());
        model.addAttribute("client",new Client());
        modelAndView.addObject("clientSex", UserSex.values());
        modelAndView.addObject("clientRole",UserRole.values());
        return "/clientAdmin/clients";
    }

    @RequestMapping(value = "clients/addClient", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("client") Client client)
    {
        if (client.getId() == 0)
        {
            clientService.addClient(client);
        }
        else
        {
            clientService.updateClient(client);
        }
        return "redirect:/clients";
    }

    @RequestMapping("/updateClient/{id}")
    public String updateClient(@PathVariable("id") int clientId, Model model)
    {
        model.addAttribute("listOfClients", clientService.getAllCliets());
        model.addAttribute("client", clientService.getClientById(clientId));

        return "/clientAdmin/clients";
    }

    @RequestMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable("id")int clientId)
    {
        clientService.deleteClient(clientService.getClientById(clientId));
        return "redirect:/clients";
    }
}
