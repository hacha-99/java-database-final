package com.project.code.Model;

import java.lang.annotation.Inherited;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id") // foreign key specification
    @JsonBackReference("inventory-product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "store_id") // foreign key specification
    @JsonBackReference("inventory-store")
    private Store store;

    private Integer stockLevel;

    // Constructor
    public Inventory(Product product, Store store, Integer stockLevel) {
        this.product = product;
        this.store = store;
        this.stockLevel = stockLevel;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Integer getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(Integer stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", product=" + (product != null ? product.getId() : "null") +
                ", store=" + (store != null ? store.getId() : "null") +
                ", stockLevel=" + stockLevel +
                '}';
    }
}

