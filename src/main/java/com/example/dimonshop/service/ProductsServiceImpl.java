package com.example.dimonshop.service;

import com.example.dimonshop.dao.ProductsDao;
import com.example.dimonshop.dao.ProductsRepository;
import com.example.dimonshop.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsDao productsDao;

    @Autowired
    ProductsRepository productsRepository;





    @Override
    @Transactional
    public Product Save(Product product) {
        return productsDao.save(product);
    }

    @Override
    public List<Product> getLimitProducts(int limit) {
        return productsDao.getLimitProducts(limit);
    }

    @Override
    public List<Product> findAllProducts() {
        return productsDao.findAllProducts();
    }

    @Transactional
    @Override
    public void delectProduct(String id) {
        productsDao.delectProduct(id);
    }

    @Override
    public Page<Product> getAllPage(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1, 2);
        return this.productsRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchProduct(String keyword, Integer pageNo) {
        List<Product> list = productsDao.searchProducts(keyword);
        Pageable pageable = PageRequest.of(pageNo-1, 2);
        Integer start = (int) pageable.getOffset();
        Integer end = pageable.getOffset()+pageable.getPageSize() > list.size() ? list.size() : (int) (pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start, end);

        return new PageImpl<Product>(list, pageable, productsDao.searchProducts(keyword).size());
    }


}
