package com.cooking.model.addition;

public enum DishType {
    SALAD("Salad"),
    SNACK("Snack"),
    FIRST_COURSE("First course"),
    SECOND_COURSE("Second course"),
    DOUGH("Dough"),
    SIDE_DISH("Side dish"),
    SAUCE("Sauce"),
    DESERT("Desert"),
    BAKE("Bake"),
    MEAT("Meat"),
    STRONG_DRINKS("Strong drinks"),
    SOFT_DRINKS("Soft drinks");

    private final String name;

    DishType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
