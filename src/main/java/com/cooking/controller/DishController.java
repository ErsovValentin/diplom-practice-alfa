package com.cooking.controller;


import com.cooking.model.Dish;
import com.cooking.model.addition.DishType;
import com.cooking.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DishController {


    @Autowired
    private DishService dishService;

    /*private final Map<DishType,String> dishTypeMap = new LinkedHashMap<DishType,String>(){
        {
          put(DishType.SALAD,"Salad");
          put(DishType.SNACK,"Snack");
          put(DishType.FIRST_COURSE,"First course");
          put(DishType.SECOND_COURSE,"Second course");
          put(DishType.DOUGH,"Dough");
          put(DishType.SIDE_DISH,"Side dish");
          put(DishType.SAUCE,"Sauce");
          put(DishType.DESERT,"Desert");
          put(DishType.BAKE,"Bake");
          put(DishType.MEAT,"Meat");
          put(DishType.STRONG_DRINKS,"Strong drinks");
          put(DishType.SOFT_DRINKS,"Soft drinks");
        }
    };*/

    @RequestMapping("/")
    public String getIndex()
    {
        return "index";
    }

    @RequestMapping("/welcome")
    public String getWelcome()
    {
        return "welcome";
    }

    @RequestMapping("/dish")
    public @ResponseBody String getOneDish()
    {
        return dishService.getAllDishes().get(0).getName();
    }


   /* @RequestMapping("/dishes")
    public @ResponseBody
    List<Dish> getAllDishes()
    {
        return adminService.getAllDishes();
    }*/



    @RequestMapping(value = "/dishes" , method = RequestMethod.GET)
    public String listOfDishes(Model model, ModelAndView modelAndView)
    {
        model.addAttribute("dish", new Dish());
        model.addAttribute("listOfDishes", dishService.getAllDishes());
//        modelAndView.addObject("dishTypes",dishTypeMap);
        modelAndView.addObject("dishTypes", DishType.values());
        return "dishes";
    }

    @RequestMapping(value = "dishes/add", method = RequestMethod.POST)
    public String addDish(@ModelAttribute("dish") Dish dish)
    {
        if (dish.getId() == 0)
        {
            dishService.addDish(dish);
        }
        else
        {
            dishService.updateDish(dish);
        }

        return "redirect:/dishes";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteDish(@PathVariable("id") int dishId)
    {
        dishService.deleteDish(dishService.getDishById(dishId));

        return "redirect:/dishes";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateDish(@PathVariable("id") int dishId , Model model)
    {
        model.addAttribute("dish", dishService.getDishById(dishId));
        model.addAttribute("listOfDishes" , dishService.getAllDishes());

        return "dishes";
    }

}
