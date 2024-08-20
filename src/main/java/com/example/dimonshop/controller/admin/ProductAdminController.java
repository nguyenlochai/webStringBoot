package com.example.dimonshop.controller.admin;

import com.example.dimonshop.dao.CategoryRepository;
import com.example.dimonshop.dao.ProductsRepository;
import com.example.dimonshop.entity.Category;
import com.example.dimonshop.entity.Product;
import com.example.dimonshop.service.ProductsService;
import com.example.dimonshop.webEntity.AddCategory;
import com.example.dimonshop.webEntity.AddProduct;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class ProductAdminController {

    private CategoryRepository categoryRepository;
    private ProductsRepository  productsRepository;
    private ProductsService productsService;



    @Autowired
    public ProductAdminController(CategoryRepository categoryRepository,ProductsRepository  productsRepository, ProductsService productsService) {
        this.categoryRepository = categoryRepository;
        this.productsRepository  = productsRepository;
        this.productsService = productsService;
    }

    @GetMapping("/product")
    public String products(Model model, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @Param("keyword") String keyword){



       Page<Product> products = productsService.getAllPage(pageNo);
       if (keyword != null){
           products = productsService.searchProduct(keyword, pageNo);
           model.addAttribute("keyword", keyword);
       }

       model.addAttribute("products", products);

        //lấy tổng số trang
       model.addAttribute("totalPage", products.getTotalPages());

       //lấy trang hiện tại
       model.addAttribute("currentPage", pageNo);
       return "admin/product/products";
    }

    @GetMapping("/showForm/product")
    public String showFormProduct(Model model){
        AddProduct addProduct = new AddProduct();
        model.addAttribute("addProduct", addProduct);
        List<Category> name_category = categoryRepository.findAll();
        model.addAttribute("name_category", name_category);
        return "admin/product/formAddProduct";
    }


    @PostMapping("/addProduct")
    public String addCategory(Model model,
                              @Valid @ModelAttribute("addProduct") AddProduct addProduct,
                              BindingResult result,
                              HttpSession session,
                              @RequestParam("image") MultipartFile file

                              ){

        String filename= file.getOriginalFilename();
        Product product = new Product();
        product.setName(addProduct.getName());
        product.setPrice(addProduct.getPrice());
        product.setDiscount(addProduct.getDiscount());
        product.setSizes(addProduct.getSizes());
        product.setQuantity(addProduct.getQuantity());
        product.setCreatedAt(System.currentTimeMillis());
        product.setTitle(addProduct.getTitle());
        product.setUpdatedAt(System.currentTimeMillis());
        product.setDetails(addProduct.getDetails());


        product.setCategory(addProduct.getCategory());

        productsRepository.save(product);
        model.addAttribute("my_error", "Thêm sản phẩm thành công");
        return "admin/product/formAddProduct";
    }





//    @PostConstruct
//    public void iii() {
//        Product product = new Product();
//        product.setName("đồng hồ");
//        product.setPrice(200.0);
//        product.setDiscount(100.0);
//        product.setSizes("M, S");
//        product.setNewProduct(1);
//        product.setQuantity(10);
//        product.setCreatedAt(System.currentTimeMillis());
//        product.setTitle("đồng hồ siêu tiện lợi");
//        product.setUpdatedAt(System.currentTimeMillis());
//        product.setDetails("đồng hồ siêu tiện lợi");
//
//
//        Category category = new Category();
//        category.setId(34);
//
//
//        product.setCategory(category);
//
//        productsRepository.save(product);
//    }

}

