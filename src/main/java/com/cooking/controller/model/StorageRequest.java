package com.cooking.controller.model;

import com.cooking.model.Client;
import com.cooking.model.Product;
import com.cooking.model.Storage;
import com.cooking.model.addition.StorageActivity;

public
class StorageRequest {

    private int id;

    private float quantityOfProduct;

    private StorageActivity activityOfProduct;

    private int productId;

    private int userId;

    public StorageRequest() {
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public float getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct(final float quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }

    public StorageActivity getActivityOfProduct() {
        return activityOfProduct;
    }

    public void setActivityOfProduct(final StorageActivity activityOfProduct) {
        this.activityOfProduct = activityOfProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(final int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public Storage toEntity(final Product product, final Client user) {
        final Storage storage = new Storage();
        storage.setQuantityOfProduct(quantityOfProduct);
        storage.setActivityOfProduct(activityOfProduct);
        storage.setStorageProduct(product);
        storage.setStorageUser(user);
        return storage;
    }

    public static StorageRequest fromEntity(final Storage storage) {
        final StorageRequest storageRequest = new StorageRequest();
        storageRequest.setId(storage.getId());
        storageRequest.setQuantityOfProduct(storage.getQuantityOfProduct());
        storageRequest.setActivityOfProduct(storage.getActivityOfProduct());
        storageRequest.setProductId(storage.getStorageProduct().getId());
        storageRequest.setUserId(storage.getStorageUser().getId());
        return storageRequest;
    }
}
