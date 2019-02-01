package com.cooking.service.impl;

import com.cooking.dao.CommentDao;
import com.cooking.model.Client;
import com.cooking.model.Comment;
import com.cooking.model.Dish;
import com.cooking.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    @Override
    public Comment getCommentById(int id) {
        return commentDao.getCommentById(id);
    }

    @Override
    public void addComment(Comment commentAdd) {
        commentDao.addComment(commentAdd);
    }

    @Override
    public void updateComment(Comment commentUpdate) {
        commentDao.updateComment(commentUpdate);
    }

    @Override
    public void deleteComment(Comment commentDelete) {
        commentDao.deleteComment(commentDelete);
    }

    @Override
    public List<Comment> getCommentsByDish(Dish dish) {
        return commentDao.getCommentsByDish(dish);
    }

    @Override
    public List<Comment> getCommentsByClient(Client client) {
        return commentDao.getCommentsByClient(client);
    }

    @Override
    public List<Comment> getCommentsByDishAndClient(Dish dish, Client client) {
        return commentDao.getCommentsByDishAndClient(dish, client);
    }
}
