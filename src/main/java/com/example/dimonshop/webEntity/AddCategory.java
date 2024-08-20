package com.example.dimonshop.webEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddCategory {
    @NotBlank(message = "Thông tin bắt buộc")
    @Size(min = 1, message = "Min là 1")
    private String name_category;

    public AddCategory(String name_category) {
        this.name_category = name_category;
    }

    public AddCategory() {
    }

    public @NotBlank(message = "Thông tin bắt buộc") @Size(min = 1, message = "Min là 1") String getName_category() {
        return name_category;
    }

    public void setName_category(@NotBlank(message = "Thông tin bắt buộc") @Size(min = 1, message = "Min là 1") String name_category) {
        this.name_category = name_category;
    }
}
