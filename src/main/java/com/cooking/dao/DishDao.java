package com.cooking.dao;

import com.cooking.model.Dish;

import java.util.ArrayList;

public interface DishDao {

    ArrayList<Dish> getAllDishes();
    Dish getDishById(int id);
    void addDish(Dish dishAdd);
    void updateDish(Dish dishUpdate);
    void deleteDish(Dish dishDelete);
}
