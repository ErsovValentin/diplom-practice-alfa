package com.cooking;

import com.cooking.config.SpringConfig;
import com.cooking.dao.*;
import com.cooking.model.*;
import com.cooking.model.addition.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        final ClientDao clientDao = context.getBean(ClientDao.class);
        final DishDao dishDao = context.getBean(DishDao.class);
        final ProductDao productDao = context.getBean(ProductDao.class);
        final StorageDao storageDao = context.getBean(StorageDao.class);
        final IngredientDao ingredientDao = context.getBean(IngredientDao.class);

//        productDao.deleteProduct(productDao.getProductById(3));


        System.out.println("**********************************CLIENTS************************************");



        Client clientFirst = new Client();
        String dob = "12.12.1999";
        Date dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").parse(dob);
        clientFirst.setDateOfBirth(dateOfBirth);
        clientFirst.setFirstName("admin");
        clientFirst.setLastName("admin");
        clientFirst.setLogin("admin");
        clientFirst.setPassword("admin");
        clientFirst.setRole(UserRole.ADMIN);
        clientFirst.setSex(UserSex.MALE);

        clientDao.addClient(clientFirst);

        System.out.println(clientDao.getAllClients());



        System.out.println("**********************************DISHES************************************");

        Dish dishadd = new Dish();
        dishadd.setName("Baked potatoes with spicy dhal");
        dishadd.setDescription("Cook red lentils with cumin, mustard seeds and turmeric and serve with a fluffy jacket potato and chutney");
        dishadd.setRecepie("Heat oven to 200C/180C fan/gas 6. Put the potatoes in the oven and bake for 1 hr until tender and the skin is crispy.\n" +
                "\n" +
                "While they are baking, make the dhal. Heat the oil in a medium pan and fry the spices to release their flavours. As soon as they start to crackle, tip in the onion, garlic and chilli, with a splash of water to stop the spices from burning. Cook for 5 mins until the onion softens.\n" +
                "\n" +
                "Add the lentils, tomato and stock, then cover and cook for 10 mins. Tip in the chickpeas, cover and cook for 10 mins more until the lentils are tender. Season to taste, stir in the coriander and spoon onto the jacket potatoes. Serve with chutney or lime pickle");
        dishadd.setType(DishType.SIDE_DISH);
        dishDao.addDish(dishadd);

        System.out.println(dishDao.getAllDishes());


        System.out.println("**********************************PRODUCTS************************************");

        Product productFirst = new Product();

        productFirst.setName("Potatoe");
        productFirst.setDescription("Potatoeeeee");
        productFirst.setMeasure(ProductMeasure.GRAM);
        productFirst.setType(ProductType.VEGETABLE);

        productDao.addProduct(productFirst);

        System.out.println(productDao.getAllProducts());



        System.out.println("**********************************Ingredient************************************");


        Ingredient ingredientFirst = new Ingredient();
        ingredientFirst.setQuantity(500);
        ingredientFirst.setIngredientDish(dishDao.getDishById(2));
        ingredientFirst.setIngredientProduct(productDao.getProductById(3));

        ingredientDao.addIngredient(ingredientFirst);

        System.out.println(ingredientDao.getAllIngredients());



        System.out.println("**********************************Storage************************************");


        Storage storageFirst = new Storage();
        storageFirst.setActivityOfProduct(StorageActivity.ACTIVE);
        storageFirst.setQuantityOfProduct(300);
        storageFirst.setStorageUser(clientDao.getClientById(1));
        storageFirst.setStorageProduct(productDao.getProductById(3));

        storageDao.addStorage(storageFirst);



        System.out.println(storageDao.getAllStorages());



        System.out.println("**********************************Favourite************************************");


        FavouriteDao favouriteDao = context.getBean(FavouriteDao.class);

        Favourite favouriteFirst = new Favourite();
        favouriteFirst.setFavouriteUser(clientDao.getClientById(1));
        favouriteFirst.setFavouriteDish(dishDao.getDishById(2));

        favouriteDao.addFavourite(favouriteFirst);

        System.out.println(favouriteDao.getAllFavourites());


        System.out.println("***********************************DELETIONS***********************");

//        productDao.deleteProduct(productDao.getProductById(3));
//        dishDao.deleteDish(dishDao.getDishById(2));
//        clientDao.deleteClient(clientDao.getClientById(1));
//        favouriteDao.deleteFavourite(favouriteDao.getFavouriteById(5));
//        ingredientDao.deleteIngredient(ingredientDao.getIngredientByDishAndProduct(dishDao.getDishById(2),productDao.getProductById(3)));

//        System.out.println(clientDao.getAllClients());
//        System.out.println(dishDao.getAllDishes());
//        System.out.println(productDao.getAllProducts());
//        System.out.println(ingredientDao.getAllIngredients());
//        System.out.println(storageDao.getAllStorages());
//        System.out.println(favouriteDao.getAllFavourites());




        /* @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private DishService dishService;

    @Autowired
    private FavouriteDao favouriteDao;*/

/*

 Dish dishadd = new Dish();
        dishadd.setName("Baked potatoes with spicy dhal");
        dishadd.setDescription("Cook red lentils with cumin, mustard seeds and turmeric and serve with a fluffy jacket potato and chutney");
        dishadd.setRecepie("Heat oven to 200C/180C fan/gas 6. Put the potatoes in the oven and bake for 1 hr until tender and the skin is crispy.\n" +
                "\n" +
                "While they are baking, make the dhal. Heat the oil in a medium pan and fry the spices to release their flavours. As soon as they start to crackle, tip in the onion, garlic and chilli, with a splash of water to stop the spices from burning. Cook for 5 mins until the onion softens.\n" +
                "\n" +
                "Add the lentils, tomato and stock, then cover and cook for 10 mins. Tip in the chickpeas, cover and cook for 10 mins more until the lentils are tender. Season to taste, stir in the coriander and spoon onto the jacket potatoes. Serve with chutney or lime pickle");
        dishadd.setType(DishType.SIDE_DISH);
        dishDao.addDish(dishadd);


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
        storageFirst.setStorageUser(clientService.getClientById(1));
        storageFirst.setStorageProduct(productService.getProductById(3));
        storageService.addStorage(storageFirst);


        Favourite favouriteFirst = new Favourite();
        favouriteFirst.setFavouriteUser(clientService.getClientById(1));
        favouriteFirst.setFavouriteDish(dishService.getDishById(2));
        favouriteDao.addFavourite(favouriteFirst);*/

    }
}
