package com.cooking.model.addition;

public enum StorageActivity {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String name;
    StorageActivity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
