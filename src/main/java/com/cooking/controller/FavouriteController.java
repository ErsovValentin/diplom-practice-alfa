package com.cooking.controller;

import com.cooking.controller.model.FavouriteRequest;
import com.cooking.model.*;
import com.cooking.service.ClientService;
import com.cooking.service.DishService;
import com.cooking.service.FavouriteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FavouriteController {

    private static final Logger LOGGER = Logger.getLogger(IngredientController.class);

    private final FavouriteService favouriteService;
    private final DishService dishService;
    private final ClientService clientService;

    @Autowired
    public FavouriteController(final FavouriteService favouriteService,
                                final DishService dishService,
                                final ClientService clientService)
    {
        this.favouriteService = favouriteService;
        this.dishService = dishService;
        this.clientService = clientService;
    }

    @RequestMapping("/favourites")
    public String listOfFavourites(Model model)
    {
        model.addAttribute("favourite", new FavouriteRequest());
        model.addAttribute("listOfFavourites", favouriteService.getAllFavourites());
        model.addAttribute("listOfDishes", dishService.getAllDishes());
        model.addAttribute("listOfClients", clientService.getAllCliets());

        return "/favouriteAdmin/favourites";
    }

    @RequestMapping(value = "favourites/addFavourite", method = RequestMethod.POST)
    public String addFavourite (@ModelAttribute("favourite")FavouriteRequest favouriteRequest)
    {
        final Dish dish = dishService.getDishById(favouriteRequest.getDishId());
        final Client client = clientService.getClientById(favouriteRequest.getUserId());

        if (favouriteRequest.getId() == 0)
        {
            final Favourite favourite = favouriteRequest.toEntity(client,dish);
            favouriteService.addFavourite(favourite);
        }
        else
        {
            final Favourite favourite = favouriteService.getFavouriteById(favouriteRequest.getId());
            favourite.setFavouriteDish(dish);
            favourite.setFavouriteUser(client);
            favouriteService.updateFavourite(favourite);
        }

        return "redirect:/favourites";
    }

    @RequestMapping(value = "/updateFavourite/{id}")
    public String updateFavourite(@PathVariable("id")int favouriteId, Model model)
    {
        final Favourite favourite = favouriteService.getFavouriteById(favouriteId);
        model.addAttribute("favourite",FavouriteRequest.fromEntity(favourite));
        model.addAttribute("listOfFavourites", favouriteService.getAllFavourites());
        model.addAttribute("listOfDishes", dishService.getAllDishes());
        model.addAttribute("listOfClients", clientService.getAllCliets());

        return "/favouriteAdmin/favourites";
    }

    @RequestMapping("/deleteFavourite/{id}")
    public String deleteFavourite(@PathVariable("id")int favouriteId)
    {
        final Favourite favourite = favouriteService.getFavouriteById(favouriteId);
        favouriteService.deleteFavourite(favourite);
        return "redirect:/favourites";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        LOGGER.warn("Returning HTTP 400 Bad Request", e);
    }

}
