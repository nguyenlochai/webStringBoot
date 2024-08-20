package com.example.dimonshop.controller.admin;

import com.example.dimonshop.dao.CategoryRepository;
import com.example.dimonshop.entity.Category;
import com.example.dimonshop.webEntity.AddCategory;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
public class CategoryAdminController {


    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryAdminController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/showForm/category")
    public String showFormCategory(Model model){
        List<Category> category = categoryRepository.findAll();
        AddCategory addCategory  = new AddCategory();
        model.addAttribute("addCategory", addCategory);
        model.addAttribute("category", category);
        return "admin/category/formAddCategory";
    }

    @InitBinder
    public void initBinder(WebDataBinder data){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/addCategory")
    public String addCategory(Model model,
                              @Valid @ModelAttribute("addCategory") AddCategory addCategory,
                              BindingResult result,
                              HttpSession session

                              ){
        String name_category = addCategory.getName_category();
        if(result.hasErrors()){
            return "admin/category/formAddCategory";
        }


        Category name_categoryExisting = categoryRepository.findByNameCategory(name_category);

        //kiem tra ton ton tai
        if (name_categoryExisting != null){
            model.addAttribute("my_error", "Đã có loại sản phẩm này, vui lòng tạo loại sản phẩm khác");
            return "admin/category/formAddCategory";
        }
        else{
            Category category = new Category();
            category.setNameCategory(name_category);
            categoryRepository.save(category);
            model.addAttribute("my_error", "Thêm loại sản phẩm thành công");
            return "admin/category/formAddCategory";
        }

    }


}
