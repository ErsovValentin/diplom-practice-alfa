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
        final StorageDao storageDao = context.getBean(StorageDao.class);
        final StorageProductsDao storageProductsDao = context.getBean(StorageProductsDao.class);
        final ProductDao productDao = context.getBean(ProductDao.class);


        final DishDao dishDao = context.getBean(DishDao.class);
        final IngredientDao ingredientDao = context.getBean(IngredientDao.class);
        final FavouriteDao favouriteDao = context.getBean(FavouriteDao.class);

        final LikeDao likeDao = context.getBean(LikeDao.class);
        final CommentDao commentDao = context.getBean(CommentDao.class);
        final RecipeStepDao recipeStepDao = context.getBean(RecipeStepDao.class);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************** CLIENTS ************************************");



        Client clientFirst = new Client();
        String dob = "12.12.1999";
        Date dateOfBirth = new SimpleDateFormat("dd.MM.yyyy").parse(dob);
        clientFirst.setDateOfBirth(dateOfBirth);
        clientFirst.setFirstName("admin");
        clientFirst.setLastName("admin");
        clientFirst.setLogin("admin");
        clientFirst.setPassword("admin");
        clientFirst.setEmail("admin@admin.ru");
        clientFirst.setRole(UserRole.ADMIN);
        clientFirst.setSex(UserSex.MALE);

        clientDao.addClient(clientFirst);


//        Client clientUpdate = clientDao.getClientById(1);
//        clientUpdate.setFirstName("user");
//        clientUpdate.setLastName("user");
//        clientDao.updateClient(clientUpdate);

        Client clientSecond = new Client();
        clientSecond.setDateOfBirth(dateOfBirth);
        clientSecond.setFirstName("user");
        clientSecond.setLastName("user");
        clientSecond.setLogin("user");
        clientSecond.setPassword("user");
        clientSecond.setEmail("user@user.ru");
        clientSecond.setRole(UserRole.USER);
        clientSecond.setSex(UserSex.MALE);
        clientDao.addClient(clientSecond);


//        System.out.println(clientDao.getAllClients());


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************** DISHES ************************************");
//
        Dish dishadd = new Dish();
        dishadd.setName("Baked potatoes with spicy dhal");
        dishadd.setDescription("Cook red lentils with cumin, mustard seeds and turmeric and serve with a fluffy jacket potato and chutney");
        dishadd.setType(DishType.SIDE_DISH);
        String dateOfCrDish = "15.12.2018 19:32:18";
        Date dateOfCreateDish = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(dateOfCrDish);
        dishadd.setDateOfCreate(dateOfCreateDish);
        dishadd.setTimeOfCooking(45.5f);
        dishadd.setAuthorClient(clientDao.getClientById(1));

        dishDao.addDish(dishadd);

        System.out.println(dishDao.getAllDishes());

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************** PRODUCTS ************************************");

        Product productFirst = new Product();

        productFirst.setName("Potatoe");
        productFirst.setDescription("Potatoeeeee");
        productFirst.setMeasure(ProductMeasure.GRAM);
        productFirst.setType(ProductType.VEGETABLE);

        productDao.addProduct(productFirst);

        System.out.println(productDao.getAllProducts());


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************** Ingredient ************************************");


        Ingredient ingredientFirst = new Ingredient();
        ingredientFirst.setQuantity(500);
        ingredientFirst.setIngredientDish(dishDao.getDishById(1));
        ingredientFirst.setIngredientProduct(productDao.getProductById(1));

        ingredientDao.addIngredient(ingredientFirst);

        System.out.println(ingredientDao.getAllIngredients());


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************** Storage ************************************");


        Storage storageFirst = new Storage();
        storageFirst.setName("First Storrage");

        storageDao.addStorage(storageFirst);
        storageDao.addStorage(new Storage());



        System.out.println(storageDao.getAllStorages());


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************** Favourite ************************************");


        Favourite favouriteFirst = new Favourite();
        favouriteFirst.setFavouriteClient(clientDao.getClientById(1));
        favouriteFirst.setFavouriteDish(dishDao.getDishById(1));

        favouriteDao.addFavourite(favouriteFirst);

        System.out.println(favouriteDao.getAllFavourites());


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*********************************** DELETIONS ***********************");

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


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*********************************** STORAGE PRODUCT ***********************");

        StorageProducts storageProducts = new StorageProducts();
        storageProducts.setStorage(storageDao.getStorageById(1));
        storageProducts.setProduct(productDao.getProductById(1));
        storageProducts.setActivityOfProduct(StorageActivity.ACTIVE);
        storageProducts.setQuantityOfProduct(15.5f);

        storageProductsDao.addStorageProducts(storageProducts);

//        StorageProducts storageProductsUpdate = storageProductsDao.getStorageProducts(storageDao.getStorageById(1), productDao.getProductById(1));
//        storageProductsUpdate.setActivityOfProduct(StorageActivity.INACTIVE);
//        storageProductsDao.updateStorageProducts(storageProductsUpdate);

//        StorageProducts storageProductsDelete = new StorageProducts();
//        storageProductsDelete.setStorage(storageDao.getStorageById(2));
//        storageProductsDelete.setProduct(productDao.getProductById(1));
//        storageProductsDao.addStorageProducts(storageProductsDelete);
//        storageProductsDao.deleteStorageProducts(storageProductsDelete);

        System.out.println(storageProductsDao.getAllStorageProducts());

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*********************************** LIKE ***********************");

        Like likeFirst = new Like();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String dateString = format.format( new Date());
        Date date = format.parse ( dateString );
        likeFirst.setDateAndTimeOfLike(date);
        likeFirst.setClient(clientDao.getClientById(1));
        likeFirst.setDishLiked(dishDao.getDishById(1));
        likeDao.addLike(likeFirst);

//        System.out.println(likeDao.getAllLikes());
//        Like likeUpdate = likeDao.getLikeById(1);
//        likeUpdate.setClient(clientDao.getClientById(2));
//        likeDao.updateLike(likeUpdate);

        Like likeSecond = new Like();
        likeSecond.setDateAndTimeOfLike(date);
        likeSecond.setClient(clientDao.getClientById(2));
        likeSecond.setDishLiked(dishDao.getDishById(1));
        likeDao.addLike(likeSecond);
//
//        likeDao.deleteLike(likeDao.getLikeById(2));


        System.out.println(likeDao.getAllLikes());

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*********************************** Comment ***********************");

        Comment commentFirst = new Comment();
        commentFirst.setClient(clientDao.getClientById(1));
        commentFirst.setDateOfCreate(date);
        commentFirst.setDishCommented(dishDao.getDishById(1));
        commentFirst.setText("Ужасное блюдо");
        commentDao.addComment(commentFirst);

//        Comment commentUpdate = commentDao.getCommentById(1);
//        commentUpdate.setText("Чудесное блюдо");
//        commentDao.updateComment(commentUpdate);

        commentFirst.setText("Чудесное блюдо");
        commentFirst.setClient(clientDao.getClientById(2));
        commentDao.addComment(commentFirst);
//
//        commentDao.deleteComment(commentDao.getCommentById(2));

        System.out.println(commentDao.getAllComments());


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*********************************** RecipeStep ***********************");

        RecipeStep recipeStep = new RecipeStep();
        recipeStep.setDescription("Очистить картофель от кожуры");
        recipeStep.setDish(dishDao.getDishById(1));
        recipeStep.setNumberOfStep(1);
        recipeStepDao.addRecipeStep(recipeStep);

        recipeStep = recipeStepDao.getRecipeStepById(1);
        recipeStep.setDescription("Помыть картофель");
        recipeStepDao.updateRecipeStep(recipeStep);


        recipeStep.setNumberOfStep(2);
        recipeStep.setDish(dishDao.getDishById(1));
        recipeStep.setDescription("Очистить картофель от кожуры");
        recipeStepDao.addRecipeStep(recipeStep);

//        recipeStepDao.deleteRecipeStep(recipeStepDao.getRecipeStepById(2));

        System.out.println(recipeStepDao.getAllRecipeSteps());

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("*********************************** SPECIAL QUERIES ***********************");

        System.out.println("***ADD STORAGE TO A CLIENT***");

        Client clientPlusStorage = clientDao.getClientById(1);
        Storage storagePlusClient = storageDao.getStorageById(1);
        clientPlusStorage.setStorage(storagePlusClient);
        clientDao.updateClient(clientPlusStorage);

        System.out.println("***GET STORAGE BY CLIENT***");
        System.out.println(storageDao.getStorageByClient(clientPlusStorage));

        System.out.println("***GET STORAGES BY PRODUCT***");
        System.out.println(storageDao.getStoragesByProduct(productDao.getProductById(1)));

        System.out.println("***GET CLIENTS BY FAVOURITE DISH***");
        System.out.println(clientDao.getClientsByFavouriteDish(dishDao.getDishById(1)));

        System.out.println("***GET CLIENT BY STORAGE***");
        System.out.println(clientDao.getClientsByStorage(storageDao.getStorageById(1)));

        System.out.println("***GET CLIENT BY AuthoredDish***");
        System.out.println(clientDao.getClientByAuthoredDish(dishDao.getDishById(1)));

        System.out.println("***GET CLIENT BY Email***");
        System.out.println(clientDao.getClientByEmail(clientDao.getClientById(1).getEmail()));

        System.out.println("***GET CLIENTs BY Liked dish***");
        System.out.println(clientDao.getClientsByLikedDish(dishDao.getDishById(1)));

        System.out.println("***GET CLIENT BY Comment***");
        System.out.println(clientDao.getClientByComment(commentDao.getCommentById(1)));

        System.out.println("***GET CLIENTs BY Comment Dish***");
        System.out.println(clientDao.getClientsByCommentedDish(dishDao.getDishById(1)));

        System.out.println("***GET FAVOURITES BY CLIENT***");
        System.out.println(favouriteDao.getFavouritesByClient(clientDao.getClientById(1)));

        System.out.println("***GET FAVOURITES BY DISH***");
        System.out.println(favouriteDao.getFavouritesByDish(dishDao.getDishById(1)));

        System.out.println("***GET DISHES BY CLIENT(FAVOURITES)***");
        System.out.println(dishDao.getFavouriteDishesByClient(clientDao.getClientById(1)));

        System.out.println("***GET DISHES BY STORAGE_PRODUCTS***");
        System.out.println(dishDao.getDishesByStorage(storageDao.getStorageById(1)));

        System.out.println("***GET DISHES BY CLIENT***");
        System.out.println(dishDao.getDishesByClient(clientDao.getClientById(1)));

        System.out.println("***GET DISHES BY PRODUCTS***");
        System.out.println(dishDao.getDishesByProduct(productDao.getProductById(1)));

        System.out.println("***GET DISHES BY Cooking time***");
        System.out.println(dishDao.getDishesByTimeOfCooking(60f));

        System.out.println("***GET DISHES BY Client like***");
        System.out.println(dishDao.getDishesByLikeClient(clientDao.getClientById(1)));

        System.out.println("***GET DISH BY Comment ***");
        System.out.println(dishDao.getDishByComment(commentDao.getCommentById(1)));

        System.out.println("***GET Commented DISH BY Client ***");
        System.out.println(dishDao.getCommentedDishesByClient(clientDao.getClientById(1)));

        System.out.println("***GET DISH BY Recipe Step ***");
        System.out.println(dishDao.getDishByRecipeStep(recipeStepDao.getRecipeStepById(1)));

        System.out.println("***GET PRODUCTS BY DISH***");
        System.out.println(productDao.getProductsByDish(dishDao.getDishById(1)));

        System.out.println("***GET PRODUCTS BY STORAGE***");
        System.out.println(productDao.getProductsByStorage(storageDao.getStorageById(1)));

        System.out.println("***GET PRODUCTS BY CLIENT***");
        System.out.println(productDao.getProductsByClient(clientDao.getClientById(1)));

        System.out.println("***GET COMMENTS BY Dish***");
        System.out.println(commentDao.getCommentsByDish(dishDao.getDishById(1)));

        System.out.println("***GET COMMENTS BY Client***");
        System.out.println(commentDao.getCommentsByClient(clientDao.getClientById(1)));

        System.out.println("***GET COMMENTS BY Dish and Client***");
        System.out.println(commentDao.getCommentsByDishAndClient(dishDao.getDishById(1),clientDao.getClientById(1)));

        System.out.println("***GET NUMBER OF LIKES BY Dish***");
        System.out.println(likeDao.getQuantityOfLikesByDish(dishDao.getDishById(1)));

        System.out.println("***GET RECIPE STEPs BY Dish***");
        System.out.println(recipeStepDao.getRecipeStepsByDish(dishDao.getDishById(1)));

    }
}
