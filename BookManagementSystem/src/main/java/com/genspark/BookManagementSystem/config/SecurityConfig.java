package com.genspark.BookManagementSystem.config;

import com.genspark.BookManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService(){

        List<com.genspark.BookManagementSystem.entity.User> users = userRepository.findAll();
        List<UserDetails> details = new ArrayList<>();

        for (var u : users){
            UserDetails ue = User
                    .withUsername(u.getEmail())
                    .password(u.getPassword())
                    .roles(u.getRole())
                    .build();
            details.add(ue);
        }

        return new InMemoryUserDetailsManager(details);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home/viewbooks")
                .hasAnyRole("ADMIN", "NORMAL")
                .requestMatchers("/home/users/**", "home/books/**")
                .hasRole("ADMIN")
                .requestMatchers("/home/public")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }

    //I tested put, post, and delete methods without security

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/home/viewbooks")
                .hasAnyRole("ADMIN", "NORMAL")
                .requestMatchers("/home/public", "/home/users/**", "home/books/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }*/
}
