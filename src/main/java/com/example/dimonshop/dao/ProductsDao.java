package com.example.dimonshop.dao;

import com.example.dimonshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsDao  {
    public List<Product> findAllProducts();
    Product save(Product product);
    List<Product> getLimitProducts(int limit);
    void delectProduct(String id);
    List<Product> searchProducts(String name);

}
