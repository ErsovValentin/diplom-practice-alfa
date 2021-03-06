package com.cooking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "storage")
public class Storage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storage_id")
    private int id;

    @Column(name = "storage_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "storage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StorageProduct> storageProducts;

    @JsonIgnore
    @OneToMany(mappedBy = "storage", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Client> clients;

    public Storage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StorageProduct> getStorageProducts() {
        return storageProducts;
    }

    public void setStorageProducts(Set<StorageProduct> storageProducts) {
        this.storageProducts = storageProducts;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
