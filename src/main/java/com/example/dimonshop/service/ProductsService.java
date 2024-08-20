package com.example.dimonshop.service;

import com.example.dimonshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public interface ProductsService {
    public Product Save(Product product);
    List<Product> getLimitProducts(int limit);
    public List<Product> findAllProducts();

    void delectProduct(String id);

    //phân trang
    Page<Product> getAllPage(Integer pageNo);

    //search
    Page<Product> searchProduct(String keyword, Integer pageNo);
}
