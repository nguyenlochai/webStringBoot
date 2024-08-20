package com.example.dimonshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {

    @GetMapping("/home")
    public String homeAdmin(){
        return "admin/home";
    }


}
