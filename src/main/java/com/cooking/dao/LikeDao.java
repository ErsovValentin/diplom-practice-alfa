package com.cooking.dao;

import com.cooking.model.Dish;
import com.cooking.model.Like;

import java.util.List;

public interface LikeDao {

    List<Like> getAllLikes();
    Like getLikeById(int id);
    void addLike(Like likeAdd);
    void updateLike(Like likeUpdate);
    void deleteLike(Like likeDelete);
    Long getQuantityOfLikesByDish(Dish dish);

}
