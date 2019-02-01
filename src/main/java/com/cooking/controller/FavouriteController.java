package com.cooking.controller;

import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Favourite;
import com.cooking.service.ClientService;
import com.cooking.service.DishService;
import com.cooking.service.FavouriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FavouriteController {

    private final FavouriteService favouriteService;
    private final ClientService clientService;
    private final DishService dishService;

    public FavouriteController(FavouriteService favouriteService,
                               ClientService clientService,
                               DishService dishService) {
        this.favouriteService = favouriteService;
        this.clientService = clientService;
        this.dishService = dishService;
    }

    @GetMapping("/favourites")
    public ResponseEntity<List<Favourite>> getAllFavourites(){
        final List<Favourite> favourites = favouriteService.getAllFavourites();
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }

    @GetMapping("/favourites/{id}")
    public ResponseEntity<Favourite> getFavouriteById(@PathVariable int id){
        final Favourite favourite = favouriteService.getFavouriteById(id);
        return new ResponseEntity<>(favourite, HttpStatus.OK);
    }

    @PostMapping("/favourites")
    public ResponseEntity<Favourite> addFavourite(@RequestBody Favourite favourite){
        favouriteService.addFavourite(favourite);
        return new ResponseEntity<>(favourite, HttpStatus.OK);
    }

    @PutMapping("/favourites")
    public ResponseEntity<Favourite> updateFavourite(@RequestBody Favourite favourite){
        favouriteService.updateFavourite(favourite);
        return new ResponseEntity<>(favourite, HttpStatus.OK);
    }

    @DeleteMapping("/favourites/{id}")
    public ResponseEntity<Favourite> deleteFavourite(@PathVariable int id){
        final Favourite favourite = favouriteService.getFavouriteById(id);
        favouriteService.deleteFavourite(favourite);
        return new ResponseEntity<>(favourite, HttpStatus.OK);
    }

    @GetMapping("/favourites/client/{id}")
    public ResponseEntity<List<Favourite>> getFavouritesByClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        final List<Favourite> favourites = favouriteService.getFavouritesByClient(client);
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }

    @GetMapping("/favourites/dish/{id}")
    public ResponseEntity<List<Favourite>> getFavouritesByDish(@PathVariable int id){
        final Dish dish = dishService.getDishById(id);
        final List<Favourite> favourites = favouriteService.getFavouritesByDish(dish);
        return new ResponseEntity<>(favourites, HttpStatus.OK);
    }
}
