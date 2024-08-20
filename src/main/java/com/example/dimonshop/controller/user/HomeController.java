package com.example.dimonshop.controller.user;

import com.example.dimonshop.dao.CategoryRepository;
import com.example.dimonshop.dao.ProductsRepository;
import com.example.dimonshop.entity.Category;
import com.example.dimonshop.entity.Product;
import com.example.dimonshop.service.ProductsService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private ProductsService productsService;

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    CategoryRepository categoryRepository;


    @RequestMapping("/home")
    public String index(Model model, Principal principal){
        model.addAttribute("username", principal.getName());
        return "user/home";

    }
    //new category
//    @PostConstruct
//    void init(){
//        Category  category = new Category();
//        category.setNameCategory("iphone");
//        categoryRepository.save(category);
//    }

//    @PostConstruct
//    void init(){
//        Product product = new Product();
//
//    }

//    @PostMapping("/add")
//    public Product addProduct(@RequestBody Product product){ nm
//        productsService.Save(product);
//        return product;
//    }
//
//    @DeleteMapping("/delete")
//    public Product deleteProduct(@RequestBody Product product){
//        productsService.Save(product);
//        return product;
//    }
//
//    @GetMapping("/displayProduct")
//    public List<Product> getProduct(){
//        List<Product> products = productsService.findAllProducts();
//        return products;
//
//    }
//
//    @GetMapping("/displayLimitProduct")
//    public List<Product> getLimitProduct(){
//        List<Product> products = productsService.getLimitProducts(3);
//        return products;
//
//    }
//
//    @DeleteMapping("/delectProduct/{id}")
//    public void delectProduct(@PathVariable("id") String id){
//        productsService.delectProduct(id);
//
//    }
}
