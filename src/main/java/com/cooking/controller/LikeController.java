package com.cooking.controller;

import com.cooking.model.Dish;
import com.cooking.model.Like;
import com.cooking.service.DishService;
import com.cooking.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LikeController {

    private final LikeService likeService;
    private final DishService dishService;

    public LikeController(LikeService likeService, DishService dishService) {
        this.likeService = likeService;
        this.dishService = dishService;
    }

    @GetMapping("/likes")
    public ResponseEntity<List<Like>> getAllLikes(){
        final List<Like> likes = likeService.getAllLikes();
        return new ResponseEntity<>(likes, HttpStatus.OK);
    }

    @GetMapping("/likes/{id}")
    public ResponseEntity<Like> getLikeById(@PathVariable int id){
        final Like like = likeService.getLikeById(id);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @PostMapping("/likes")
    public ResponseEntity<Like> addLike(@RequestBody Like like){
        likeService.addLike(like);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @PutMapping("/likes")
    public ResponseEntity<Like> updateLike(@RequestBody Like like){
        likeService.updateLike(like);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @DeleteMapping("/likes/{id}")
    public ResponseEntity<Like> deleteLike(@PathVariable int id){
        final Like like = likeService.getLikeById(id);
        likeService.deleteLike(like);
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    @GetMapping("/likes/dish/{id}")
    public ResponseEntity<Long> getQuantityOfLikesByDish(@PathVariable int id){
        final Dish dish = dishService.getDishById(id);
        final Long quantityOfLikes = likeService.getQuantityOfLikesByDish(dish);
        return new ResponseEntity<>(quantityOfLikes, HttpStatus.OK);
    }
}
