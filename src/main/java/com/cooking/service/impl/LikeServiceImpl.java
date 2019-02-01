package com.cooking.service.impl;

import com.cooking.dao.LikeDao;
import com.cooking.model.Dish;
import com.cooking.model.Like;
import com.cooking.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private final LikeDao likeDao;

    public LikeServiceImpl(LikeDao likeDao) {
        this.likeDao = likeDao;
    }

    @Override
    public List<Like> getAllLikes() {
        return likeDao.getAllLikes();
    }

    @Override
    public Like getLikeById(int id) {
        return likeDao.getLikeById(id);
    }

    @Override
    public void addLike(Like likeAdd) {
        likeDao.addLike(likeAdd);
    }

    @Override
    public void updateLike(Like likeUpdate) {
        likeDao.updateLike(likeUpdate);
    }

    @Override
    public void deleteLike(Like likeDelete) {
        likeDao.deleteLike(likeDelete);
    }

    @Override
    public Long getQuantityOfLikesByDish(Dish dish) {
        return likeDao.getQuantityOfLikesByDish(dish);
    }
}
