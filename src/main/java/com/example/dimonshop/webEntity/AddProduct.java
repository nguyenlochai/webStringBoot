package com.example.dimonshop.webEntity;

import com.example.dimonshop.entity.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;

import java.sql.Blob;

public class AddProduct {

    @NotBlank(message = "Thông tin bắt buộc")
    @Size(min = 1, message = "Min là 1")
    private String name;

    @NotBlank(message = "Thông tin bắt buộc")
    @Size(min = 1, message = "Min là 1")
    private String title;

    @NotNull(message = "Thông tin bắt buộc")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá không được nhỏ hơn 0")
    private Double price;

    @NotNull(message = "Thông tin bắt buộc")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giảm giá không được nhỏ hơn 0")
    private Double discount;

    private String sizes;

    @Min(value = 1, message = "Số lượng phải lớn hơn hoặc bằng 1")
    private int quantity;

    private String details;

    private Blob image;

    private Category category;

    public AddProduct(String name, String title, Double price, Double discount, String sizes, int quantity, String details, Blob image, Category category) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.sizes = sizes;
        this.quantity = quantity;
        this.details = details;
        this.image = image;
        this.category = category;
        this.title = title;
    }

    public AddProduct() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
