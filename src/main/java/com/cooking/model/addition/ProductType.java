package com.cooking.model.addition;

public enum ProductType {
    VEGETABLE("Vegetable"),
    FRUIT("Fruit"),
    MUSHROOMS("Mushrooms"),
    BERRY("Berry"),
    NUT("Nut"),
    DRIED_FRUIT("Dried fruit"),
    GREENERY("Greenery"),
    FLOWER("Flower"),
    SPICE("Spice"),
    GROATS("Groats"),
    FLOURY("Floury"),
    SWEETS("Sweets"),
    MEAT("Meat"),
    FISH("Fish"),
    SEAFOOD("Seafood"),
    EGG("Egg"),
    DAIRY("Dairy"),
    BABY("Baby");

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
