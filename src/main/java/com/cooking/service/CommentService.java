package com.cooking.service;

import com.cooking.model.Client;
import com.cooking.model.Comment;
import com.cooking.model.Dish;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComments();
    Comment getCommentById(int id);
    void addComment(Comment commentAdd);
    void updateComment(Comment commentUpdate);
    void deleteComment(Comment commentDelete);
    List<Comment> getCommentsByDish(Dish dish);
    List<Comment> getCommentsByClient(Client client);
    List<Comment> getCommentsByDishAndClient(Dish dish, Client client);
}
