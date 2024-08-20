package com.example.dimonshop.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;


    private Double price;




    private Double discount;


    private String sizes;


    private int newProduct;


    private int quantity;


    private String title;


    private long createdAt;


    private long updatedAt;


    private String details;

    private Blob image;


    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;




    public Product() {
    }

    public Product(String name, Double price, Double discount, String sizes, int newProduct, int quantity, long createdAt, String title, long updatedAt, String details, Blob image, Category category) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.sizes = sizes;
        this.newProduct = newProduct;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.title = title;
        this.updatedAt = updatedAt;
        this.details = details;
        this.image = image;
        this.category = category;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public int getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(int newProduct) {
        this.newProduct = newProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
