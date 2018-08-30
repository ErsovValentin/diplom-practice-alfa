package com.cooking.model.addition;

public enum UserSex {
    MALE("Male"),
    FEMALE("Female");

    private String name;

    UserSex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
