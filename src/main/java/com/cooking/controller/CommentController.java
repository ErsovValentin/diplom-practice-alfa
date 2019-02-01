package com.cooking.controller;

import com.cooking.model.Client;
import com.cooking.model.Comment;
import com.cooking.model.Dish;
import com.cooking.service.ClientService;
import com.cooking.service.CommentService;
import com.cooking.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {

    private final CommentService commentService;
    private final DishService dishService;
    private final ClientService clientService;

    public CommentController(CommentService commentService,
                             DishService dishService,
                             ClientService clientService) {
        this.commentService = commentService;
        this.dishService = dishService;
        this.clientService = clientService;
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments(){
        final List<Comment> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable int id){
        final Comment comment = commentService.getCommentById(id);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/comments")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment){
        commentService.updateComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable int id){
        final Comment comment = commentService.getCommentById(id);
        commentService.deleteComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @GetMapping("/comments/dish/{id}")
    public ResponseEntity<List<Comment>> getCommentsByDish(@PathVariable int id){
        final Dish dish = dishService.getDishById(id);
        final List<Comment> comments = commentService.getCommentsByDish(dish);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/client/{id}")
    public ResponseEntity<List<Comment>> getCommentsByClient(@PathVariable int id){
        final Client client = clientService.getClientById(id);
        final List<Comment> comments = commentService.getCommentsByClient(client);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/comments/dish/{dishId}/client/{clientId}")
    public ResponseEntity<List<Comment>> getCommentsByDishAndClient(@PathVariable("dishId") int dishId, @PathVariable("clientId")int clientId){
        final Dish dish = dishService.getDishById(dishId);
        final Client client = clientService.getClientById(clientId);
        final List<Comment> comments = commentService.getCommentsByDishAndClient(dish, client);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
