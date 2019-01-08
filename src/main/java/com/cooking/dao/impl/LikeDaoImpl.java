package com.cooking.dao.impl;

import com.cooking.dao.LikeDao;
import com.cooking.model.Dish;
import com.cooking.model.Like;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LikeDaoImpl implements LikeDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public LikeDaoImpl(final SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    private Session session()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Like> getAllLikes() {
        return session()
                .createQuery("from Like ", Like.class)
                .list();
    }

    @Override
    public Like getLikeById(int id) {
        return session().get(Like.class,id);
    }

    @Override
    public void addLike(Like likeAdd) {
        session().save(likeAdd);
    }

    @Override
    public void updateLike(Like likeUpdate) {
        session().merge(likeUpdate);
    }

    @Override
    public void deleteLike(Like likeDelete) {
        session().delete(likeDelete);
    }

    @Override
    public Long getQuantityOfLikesByDish(Dish dish) {
        return session()
                .createQuery("select count(*) from Like as l where l.dishLiked = ?1", Long.class)
                .setParameter(1, dish)
                .uniqueResult();
    }
}
