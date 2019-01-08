package com.cooking.service;

import com.cooking.model.Client;
import com.cooking.model.Dish;
import com.cooking.model.Product;
import com.cooking.model.Storage;

import java.util.ArrayList;
import java.util.List;

public interface DishService {

    ArrayList<Dish> getAllDishes();
    Dish getDishById(int id);
    void addDish(Dish dishAdd);
    void updateDish(Dish dishUpdate);
    void deleteDish(Dish dishDelete);
    List<Dish> getDishesByProduct(Product product);
    List<Dish> getFavouriteDishesByClient(Client client);
    List<Dish> getDishesByStorage(Storage storage);
    List<Dish> getDishesByClient(Client client);
}
