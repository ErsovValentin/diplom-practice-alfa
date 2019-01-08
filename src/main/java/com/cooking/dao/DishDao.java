package com.cooking.dao;

import com.cooking.model.*;

import java.util.ArrayList;
import java.util.List;

public interface DishDao {

    ArrayList<Dish> getAllDishes();
    Dish getDishById(int id);
    void addDish(Dish dishAdd);
    void updateDish(Dish dishUpdate);
    void deleteDish(Dish dishDelete);
    List<Dish> getDishesByProduct(Product product);
    List<Dish> getFavouriteDishesByClient(Client client);
    List<Dish> getDishesByStorage(Storage storage);
    List<Dish> getDishesByClient(Client client);
    List<Dish> getDishesByTimeOfCooking(float timeOfCooking);
    List<Dish> getDishesByLikeClient(Client client);
    Dish getDishByComment(Comment comment);
    List<Dish> getCommentedDishesByClient(Client client);
    Dish getDishByRecipeStep(RecipeStep recipeStep);

}
