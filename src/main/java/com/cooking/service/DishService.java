package com.cooking.service;


import com.cooking.dao.DishDao;
import com.cooking.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    DishDao dishDao;

    public List<Dish> getAllDishes()
    {
        return dishDao.getAllDishes();
    }
    public Dish getDishById(int dishId){return dishDao.getDishById(dishId);}
    public void addDish(Dish dishAdd){dishDao.addDish(dishAdd);}
    public void updateDish (Dish dishUpdate) { dishDao.updateDish(dishUpdate);}
    public void deleteDish (Dish dishDelete) {dishDao.deleteDish(dishDelete);}

}
