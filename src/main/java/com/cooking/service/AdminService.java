package com.cooking.service;


import com.cooking.dao.DishDao;
import com.cooking.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    DishDao dishDao;

    public List<Dish> getAllDishes()
    {
        return dishDao.getAllDishes();
    }
}
