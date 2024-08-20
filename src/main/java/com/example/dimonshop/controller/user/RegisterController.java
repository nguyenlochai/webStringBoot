package com.example.dimonshop.controller.user;

import com.example.dimonshop.dao.RoleRepository;
import com.example.dimonshop.dao.UserRepository;
import com.example.dimonshop.entity.Role;
import com.example.dimonshop.entity.User;
import com.example.dimonshop.service.UserService;
import com.example.dimonshop.webEntity.UserRegister;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserRepository userRepository;
    private UserService userService;
    private RoleRepository roleRepository;

    public RegisterController(UserRepository userRepository, UserService userService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/showRegisterForm")
    public String register(Model model){
        UserRegister register =  new UserRegister();
        model.addAttribute("registerUser", register);
        return "user/register/formRegister";
    }

    @InitBinder
    public void initBinder(WebDataBinder data){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        data.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/registering")
    public String registering(
                                Model model,
                                @Valid @ModelAttribute("registerUser") UserRegister register,
                                BindingResult result,
                                HttpSession session){

        String username = register.getUsername();

        //valication
        if (result.hasErrors()){
            return "user/register/formRegister";
        }

        // kiểm tra username có tồn tại không
        User userExisting =  userService.findByUsername(username);

        //nếu tồn tại
        if (userExisting != null){
            model.addAttribute("my_error", "tài khoản đã tồn tại, vui lòng tạo tài khoản khác");
            return "user/register/formRegister";
        }
        //nếu không tồn tài
        else{
            User user = new User();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setUsername(register.getUsername());
            user.setPassword(passwordEncoder.encode(register.getPassword()));
            user.setSdt(register.getSdt());
            user.setAddress(register.getAddress());
            user.setLastName(register.getLastName());
            user.setFirstName(register.getFirstName());
            user.setEmail(register.getEmail());
            user.setEnabled(true);

            // mặt định là USER_ROLE
            Role defaultRole = roleRepository.findByName("ROLE_USER");
            Collection<Role> roles = new ArrayList<>();
            roles.add(defaultRole);
            user.setRoles(roles);

            userRepository.save(user);
            session.setAttribute("myUser" ,user);
            return "user/register/formRegister";
        }

    }
}
