package com.cooking.controller;

import com.cooking.controller.model.StorageRequest;
import com.cooking.dao.FavouriteDao;
import com.cooking.dao.IngredientDao;
import com.cooking.model.Client;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.addition.StorageActivity;
import com.cooking.service.ClientService;
import com.cooking.service.DishService;
import com.cooking.service.ProductService;
import com.cooking.service.StorageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StorageController {

    private static final Logger logger = Logger.getLogger(StorageController.class);

    private final StorageService storageService;
    private final ClientService clientService;
    private final ProductService productService;
    private final IngredientDao ingredientDao;
    private final DishService dishService;
    private final FavouriteDao favouriteDao;

    @Autowired
    public StorageController(final StorageService storageService,
                      final ClientService clientService,
                      final ProductService productService,
                      final IngredientDao ingredientDao,
                      final DishService dishService,
                      final FavouriteDao favouriteDao) {
        this.storageService = storageService;
        this.clientService = clientService;
        this.productService = productService;
        this.ingredientDao = ingredientDao;
        this.dishService = dishService;
        this.favouriteDao = favouriteDao;
    }

    @RequestMapping("/storages")
    public String listOfStorages(Model model, ModelAndView modelAndView)
    {
       /* Dish dishadd = new Dish();
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
        storageFirst.setActivityOfProduct(StorageActivity.INACTIVE);
        storageFirst.setQuantityOfProduct(300);
        storageFirst.setStorageUser(clientService.getClientById(2));
        storageFirst.setStorageProduct(productService.getProductById(3));
        storageService.addStorage(storageFirst);


        Favourite favouriteFirst = new Favourite();
        favouriteFirst.setFavouriteUser(clientService.getClientById(2));
        favouriteFirst.setFavouriteDish(dishService.getDishById(1));
        favouriteDao.addFavourite(favouriteFirst);*/

        model.addAttribute("listOfStorages", storageService.getAllStorages());
        model.addAttribute("storage",new StorageRequest());
        model.addAttribute("listOfClients",clientService.getAllCliets());
        model.addAttribute("listOfProducts",productService.getAllProducts());
        modelAndView.addObject("storageActivity",StorageActivity.values());
        modelAndView.addObject("active",StorageActivity.ACTIVE);

        return "/storageAdmin/storages";
    }

    @RequestMapping(value = "storages/addStorage", method = RequestMethod.POST)
    public String addStorage(@ModelAttribute("storage") StorageRequest storageRequest)
    {
        final Product product = productService.getProductById(storageRequest.getProductId());
        final Client  user = clientService.getClientById(storageRequest.getUserId());

        if(storageRequest.getId() == 0)
        {
            final Storage storage = storageRequest.toEntity(product, user);
            storageService.addStorage(storage);
        }
        else
        {
            final Storage storage = storageService.getStorageById(storageRequest.getId());
            storage.setStorageProduct(product);
            storage.setStorageUser(user);
            storage.setActivityOfProduct(storageRequest.getActivityOfProduct());
            storage.setQuantityOfProduct(storageRequest.getQuantityOfProduct());
            storageService.updateStorage(storage);
        }

        return "redirect:/storages";
    }

    @RequestMapping(value="/updateStorage/{id}")
    public String updateStorage(@PathVariable("id") int storageId, Model model, ModelAndView modelAndView)
    {
        final Storage storage = storageService.getStorageById(storageId);

        model.addAttribute("storage", StorageRequest.fromEntity(storage));
        modelAndView.addObject("storageActivity",StorageActivity.values());
        model.addAttribute("listOfStorages",storageService.getAllStorages());
        model.addAttribute("listOfClients",clientService.getAllCliets());
        model.addAttribute("listOfProducts",productService.getAllProducts());

        return "/storageAdmin/storages";
    }

    @RequestMapping("/deleteStorage/{id}")
    public String deleteStorage(@PathVariable("id") int storageId)
    {
        storageService.deleteStorage(storageService.getStorageById(storageId));

        return "redirect:/storages";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e) {
        logger.warn("Returning HTTP 400 Bad Request", e);
    }
}
