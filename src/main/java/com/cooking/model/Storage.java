package com.cooking.model;


import com.cooking.model.addition.StorageActivity;

import javax.persistence.*;

@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "storage_id")
    private int id;

    @Column(name = "quantity_product")
    private float quantityOfProduct;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_activity")
    private StorageActivity activityOfProduct;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product storageProduct;

    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Client storageUser;

    public Storage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Product getStorageProduct() {
        return storageProduct;
    }

    public void setStorageProduct(Product storageProduct) {
        this.storageProduct = storageProduct;
    }

    public Client getStorageUser() {
        return storageUser;
    }

    public void setStorageUser(Client storageUser) {
        this.storageUser = storageUser;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", quantityOfProduct=" + quantityOfProduct +
                ", activityOfProduct=" + activityOfProduct +
                ", storageProduct=" + storageProduct.getName() +
                ", storageUser=" + storageUser.getFirstName() + " " + storageUser.getLastName()+
                '}';
    }
}
