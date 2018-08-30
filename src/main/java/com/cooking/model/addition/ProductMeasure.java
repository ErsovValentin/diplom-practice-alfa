package com.cooking.model.addition;

public enum ProductMeasure {
    GRAM("Gramm"),
    MILLIGRAM("Milligramm"),
    KILOGRAM("Kilogram"),
    LITER("Liter"),
    MILLILITER("Milliliter"),
    UNIT("Unit");

    private String name;
    ProductMeasure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
