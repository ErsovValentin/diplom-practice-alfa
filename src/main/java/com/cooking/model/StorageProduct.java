package com.cooking.model;

import com.cooking.model.addition.StorageActivity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "storage_products",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"storage_id", "product_id"})})
public class StorageProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storage_products_id")
    private int id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity_product", nullable = false)
    private float quantityOfProduct;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_activity", nullable = false)
    private StorageActivity activityOfProduct;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct(float quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }

    public StorageActivity getActivityOfProduct() {
        return activityOfProduct;
    }

    public void setActivityOfProduct(StorageActivity activityOfProduct) {
        this.activityOfProduct = activityOfProduct;
    }

    @Override
    public String toString() {
        return "StorageProduct{" +
                "storage=" + storage.getName() +
                ", product=" + product.getName() +
                ", quantityOfProduct=" + quantityOfProduct +
                ", activityOfProduct=" + activityOfProduct +
                '}';
    }
}
