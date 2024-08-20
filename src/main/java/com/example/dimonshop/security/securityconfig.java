package com.example.dimonshop.security;

import com.example.dimonshop.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityconfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return  daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)  throws Exception{
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers("/assets/**").permitAll() //cho chép truy cập tài nguyên tĩnh
                        .requestMatchers("/register/**").permitAll()
                        .anyRequest().authenticated()

        ).formLogin(
                form->form.loginPage("/loginUser")

                        .loginProcessingUrl("/authenticateTheUser") // mặc định
                        .defaultSuccessUrl("/home", true) // Chuyển hướng về trang index sau khi đăng nhập thành công
                        .permitAll()
        ).logout(
                logout->logout
                .logoutSuccessUrl("/loginUser")//chuyển đến url loginUser khi đăng xuất
                .permitAll()
        ).exceptionHandling(
                configurer->configurer.accessDeniedPage("/showPage403")
        );

          return http.build();
    }
}
