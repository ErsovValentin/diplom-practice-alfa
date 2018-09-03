package com.cooking.controller;

import com.cooking.dao.FavouriteDao;
import com.cooking.dao.IngredientDao;
import com.cooking.model.Storage;
import com.cooking.model.addition.StorageActivity;
import com.cooking.service.ClientService;
import com.cooking.service.DishService;
import com.cooking.service.ProductService;
import com.cooking.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StorageController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

     @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private DishService dishService;

    @Autowired
    private FavouriteDao favouriteDao;




    @RequestMapping("/storages")
    public String listOfStorages(Model model, ModelAndView modelAndView)
    {
        /*Dish dishadd = new Dish();
        dishadd.setName("Baked potatoes with spicy dhal");
        dishadd.setDescription("Cook red lentils with cumin, mustard seeds and turmeric and serve with a fluffy jacket potato and chutney");
        dishadd.setRecepie("Heat oven to 200C/180C fan/gas 6. Put the potatoes in the oven and bake for 1 hr until tender and the skin is crispy.\n" +
                "\n" +
                "While they are baking, make the dhal. Heat the oil in a medium pan and fry the spices to release their flavours. As soon as they start to crackle, tip in the onion, garlic and chilli, with a splash of water to stop the spices from burning. Cook for 5 mins until the onion softens.\n" +
                "\n" +
                "Add the lentils, tomato and stock, then cover and cook for 10 mins. Tip in the chickpeas, cover and cook for 10 mins more until the lentils are tender. Season to taste, stir in the coriander and spoon onto the jacket potatoes. Serve with chutney or lime pickle");
        dishadd.setType(DishType.SIDE_DISH);
        dishService.addDish(dishadd);


        Client clientFirst = new Client();
        String dob = "12.12.1999";
        Date dateOfBirth = null;
        try {
            dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").parse(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        clientFirst.setDateOfBirth(dateOfBirth);
        clientFirst.setFirstName("admin");
        clientFirst.setLastName("admin");
        clientFirst.setLogin("admin");
        clientFirst.setPassword("admin");
        clientFirst.setRole(UserRole.ADMIN);
        clientFirst.setSex(UserSex.MALE);
        clientService.addClient(clientFirst);


        Product productFirst = new Product();
        productFirst.setName("Potatoe");
        productFirst.setDescription("Potatoeeeee");
        productFirst.setMeasure(ProductMeasure.GRAM);
        productFirst.setType(ProductType.VEGETABLE);
        productService.addProduct(productFirst);

        Ingredient ingredientFirst = new Ingredient();
        ingredientFirst.setQuantity(500);
        ingredientFirst.setIngredientDish(dishService.getDishById(1));
        ingredientFirst.setIngredientProduct(productService.getProductById(3));
        ingredientDao.addIngredient(ingredientFirst);


        Storage storageFirst = new Storage();
        storageFirst.setActivityOfProduct(StorageActivity.ACTIVE);
        storageFirst.setQuantityOfProduct(300);
        storageFirst.setStorageUser(clientService.getClientById(2));
        storageFirst.setStorageProduct(productService.getProductById(3));
        storageService.addStorage(storageFirst);


        Favourite favouriteFirst = new Favourite();
        favouriteFirst.setFavouriteUser(clientService.getClientById(2));
        favouriteFirst.setFavouriteDish(dishService.getDishById(1));
        favouriteDao.addFavourite(favouriteFirst);*/



        model.addAttribute("listOfStorages", storageService.getAllStorages());
        model.addAttribute("storage",new Storage());
        model.addAttribute("listOfClients",clientService.getAllCliets());
        model.addAttribute("listOfProducts",productService.getAllProducts());
        modelAndView.addObject("active",StorageActivity.ACTIVE);
        modelAndView.addObject("storageActivity",StorageActivity.values());

        return "/storageAdmin/storages";
    }

    @RequestMapping(value = "storages/addStorage", method = RequestMethod.POST)
    public String addStorage(@ModelAttribute("storage")Storage storage)
    {
        if(storage.getId() == 0)
        {
            storageService.addStorage(storage);
        }
        else
        {
            storageService.updateStorage(storage);
        }

        return "redirect:/storages";
    }

    @RequestMapping("/updateStorage/{id}")
    public String updateStorage(@PathVariable("id") int storageId, Model model)
    {
        model.addAttribute("listOfStorages",storageService.getAllStorages());
        model.addAttribute("storage", storageService.getStorageById(storageId));

        return "/storageAdmin/storages";
    }

    @RequestMapping("/deleteStorage/{id}")
    public String deleteStorage(@PathVariable("id") int storageId)
    {
        storageService.deleteStorage(storageService.getStorageById(storageId));

        return "redirect:/storages";
    }
}
