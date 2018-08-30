package com.cooking.model.addition;

public enum  UserRole {
    USER("User"),
    ADMIN("Admin");

    private String name;
    UserRole(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
