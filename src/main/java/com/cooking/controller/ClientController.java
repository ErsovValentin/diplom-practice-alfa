package com.cooking.controller;

import com.cooking.model.Client;
import com.cooking.model.Comment;
import com.cooking.model.Dish;
import com.cooking.model.Storage;
import com.cooking.service.ClientService;
import com.cooking.service.CommentService;
import com.cooking.service.DishService;
import com.cooking.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    private final ClientService clientService;
    private final StorageService storageService;
    private final DishService dishService;
    private final CommentService commentService;

    public ClientController(ClientService clientService,
                            StorageService storageService,
                            DishService dishService,
                            CommentService commentService) {
        this.clientService = clientService;
        this.storageService = storageService;
        this.dishService = dishService;
        this.commentService = commentService;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients(){
        final ArrayList<Client> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") int id){
        final Client client = clientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        clientService.addClient(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/clients")
    public ResponseEntity<Client> updateClient(@RequestBody Client client ){
        clientService.updateClient(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        clientService.deleteClient(client);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/clients/storage/{id}")
    public ResponseEntity<List<Client>> getClientsByStorage(@PathVariable int id){
        final Storage storage = storageService.getStorageById(id);
        final List<Client> clients = clientService.getClientsByStorage(storage);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/clients/favourite/dish/{id}")
    public ResponseEntity<List<Client>> getClientsByFavouriteDish(@PathVariable int id){
        final Dish dishFavourite = dishService.getDishById(id);
        final List<Client> clients = clientService.getClientsByFavouriteDish(dishFavourite);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/clients/authored-dish/{id}")
    public ResponseEntity<Client> getClientByAuthoredDish(@PathVariable int id){
        final Dish dishAuthored = dishService.getDishById(id);
        final Client client = clientService.getClientByAuthoredDish(dishAuthored);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    /**
     *
     * Request type "Text", without quotes
     * Example:
     *  admin@admin.ru
     *
     */
    @PostMapping("/clients/email")
    public ResponseEntity<Client> getClientByEmail(@RequestBody String email){
        final Client client = clientService.getClientByEmail(email);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/clients/liked-dish/{id}")
    public ResponseEntity<List<Client>> getClientsByLikedDish(@PathVariable int id){
        final Dish dishLiked = dishService.getDishById(id);
        final List<Client> clients = clientService.getClientsByLikedDish(dishLiked);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/clients/comment/{id}")
    public ResponseEntity<Client> getClientByComment(@PathVariable int id){
        final Comment comment = commentService.getCommentById(id);
        final Client client = clientService.getClientByComment(comment);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @GetMapping("/clients/commented-dish/{id}")
    public ResponseEntity<List<Client>> getClientsByCommentedDish(@PathVariable int id){
        final Dish dishCommented = dishService.getDishById(id);
        final List<Client> clients = clientService.getClientsByCommentedDish(dishCommented);
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
 }
