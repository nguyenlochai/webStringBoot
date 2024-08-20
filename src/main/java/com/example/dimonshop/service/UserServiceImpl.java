package com.example.dimonshop.service;

import com.example.dimonshop.dao.CategoryRepository;
import com.example.dimonshop.dao.ProductsRepository;
import com.example.dimonshop.dao.UserRepository;
import com.example.dimonshop.entity.Category;
import com.example.dimonshop.entity.Product;
import com.example.dimonshop.entity.Role;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.example.dimonshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    private EntityManager entityManager;




    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),rolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

//    @PostConstruct
//     void init(){
//        User user = new User();
//        user.setUsername("hai");
//        user.setPassword("your_password");
//        user.setEnabled(true);
//        user.setSdt(123456789);
//        user.setAddress("Your address");
//        user.setFirstName("Your first name");
//        user.setLastName("Your last name");
//        user.setEmail("your_email@example.com");
//
//        userRepository.save(user);
//    }





}
