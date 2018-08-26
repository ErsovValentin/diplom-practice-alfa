package com.cooking.controller;


import com.cooking.model.Dish;
import com.cooking.model.addition.DishType;
import com.cooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {


    @Autowired
    private AdminService adminService;

    private final Map<String,DishType> dishTypeMap = new LinkedHashMap<String, DishType>(){
        {
          put("Salad",DishType.SALAD);
          put("Snack",DishType.SNACK);
          put("First course",DishType.FIRST_COURSE);
          put("Second course", DishType.SECOND_COURSE);
          put("Dough",DishType.DOUGH);
          put("Side dish", DishType.SIDE_DISH);
          put("Sauce",DishType.SAUCE);
          put("Desert",DishType.DESERT);
          put("Bake",DishType.BAKE);
          put("Meat",DishType.MEAT);
          put("Strong drinks", DishType.STRONG_DRINKS);
          put("Soft drinks", DishType.SOFT_DRINKS);
        }
    };

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
        return adminService.getAllDishes().get(0).getName();
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
        model.addAttribute("listOfDishes", adminService.getAllDishes());
        modelAndView.addObject("dishTypes",dishTypeMap);
        return "dishes";
    }

    @RequestMapping(value = "dishes/add", method = RequestMethod.POST)
    public String addDish(@ModelAttribute("dish") Dish dish, Model model)
    {
        if (dish.getId() == 0)
        {
            adminService.addDish(dish);
        }
        else
        {
            adminService.updateDish(dish);
        }

        return "redirect:/dishes";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteDish(@PathVariable("id") int dishId)
    {
        adminService.deleteDish(adminService.getDishById(dishId));

        return "redirect:/dishes";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateDish(@PathVariable("id") int dishId , Model model)
    {
        model.addAttribute("dish",adminService.getDishById(dishId));
        model.addAttribute("listOfDishes" , adminService.getAllDishes());

        return "dishes";
    }

}
