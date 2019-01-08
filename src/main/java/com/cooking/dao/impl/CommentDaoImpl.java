package com.cooking.dao.impl;

import com.cooking.dao.CommentDao;
import com.cooking.model.Client;
import com.cooking.model.Comment;
import com.cooking.model.Dish;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CommentDaoImpl implements CommentDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public CommentDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Comment> getAllComments() {
        return session()
                .createQuery("from Comment ", Comment.class)
                .list();
    }

    @Override
    public Comment getCommentById(int id) {
        return session()
                .get(Comment.class, id);
    }

    @Override
    public void addComment(Comment commentAdd) {
        session().save(commentAdd);
    }

    @Override
    public void updateComment(Comment commentUpdate) {
        session().merge(commentUpdate);
    }

    @Override
    public void deleteComment(Comment commentDelete) {
        session().delete(commentDelete);
    }

    @Override
    public List<Comment> getCommentsByDish(Dish dish) {
        return session()
                .createQuery("from Comment as c where c.dishCommented = ?1", Comment.class)
                .setParameter(1,dish)
                .list();
    }

    @Override
    public List<Comment> getCommentsByClient(Client client) {
        return session()
                .createQuery("from Comment as c where c.client = ?1", Comment.class)
                .setParameter(1, client)
                .list();
    }

    @Override
    public List<Comment> getCommentsByDishAndClient(Dish dish, Client client) {
        return session()
                .createQuery("from Comment as c where c.dishCommented = ?1 and c.client = ?2", Comment.class)
                .setParameter(1, dish)
                .setParameter(2, client)
                .list();
    }
}
