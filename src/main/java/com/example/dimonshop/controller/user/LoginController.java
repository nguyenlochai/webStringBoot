package com.example.dimonshop.controller.user;

import com.example.dimonshop.webEntity.UserRegister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginUser")
    public String register(Model model){

        return "user/login/formLogin";
    }

    @GetMapping("/showPage403")
    public String showPage403(){
        return "error/403";
    }

}
