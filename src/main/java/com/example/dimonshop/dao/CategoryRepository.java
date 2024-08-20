package com.example.dimonshop.dao;

import com.example.dimonshop.entity.Category;
import com.example.dimonshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByNameCategory(String nameCategory);
}
