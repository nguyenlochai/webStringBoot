package com.example.dimonshop.dao;



import com.example.dimonshop.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDaoImpl implements ProductsDao {

    private EntityManager entityManager;

    @Autowired
    public ProductsDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Transactional
    @Override
    public Product save(Product product) {
        product.setCreatedAt(System.currentTimeMillis());
        product.setUpdatedAt(System.currentTimeMillis());
        this.entityManager.persist(product);
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        String jpql = "SELECT s FROM product s";
        return this.entityManager.createQuery(jpql, Product.class).getResultList();
    }

    @Override
    public List<Product> getLimitProducts(int limit) {
        String sql = "SELECT * FROM product ORDER BY RAND() LIMIT :limit";
        Query query = entityManager.createNativeQuery(sql, Product.class);
        query.setParameter("limit", limit);
        return query.getResultList();
    }


    @Override
    public void delectProduct(String id) {
        Product product =  this.entityManager.find(Product.class, id);
        this.entityManager.remove(product);
    }

    @Override
    public List<Product> searchProducts(String name) {
        String jpql = "SELECT c FROM Product c WHERE c.name LIKE :name";
        Query query = entityManager.createQuery(jpql, Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }



}
