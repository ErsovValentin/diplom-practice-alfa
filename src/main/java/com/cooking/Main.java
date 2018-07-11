package com.cooking;

import com.cooking.config.SpringConfig;
import com.cooking.dao.DishDao;
import com.cooking.model.Dish;
import com.cooking.model.addition.DishType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        final DishDao dishDao = context.getBean(DishDao.class);


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

        /*Dish dishUpdate = dishDao.getDishById(1);
        dishUpdate.setName("MeatDish");
        dishDao.updateDish(dishUpdate);*/


        System.out.println(dishDao.getAllDishes());
    }
}
