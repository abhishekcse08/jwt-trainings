package com.magnus.jwt;

import com.magnus.jwt.entity.User;
import com.magnus.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "abhishekcse08", "password", "abhishekcse08@gmail.com"),
                new User(102, "Jhon", "pwd1", "jhon@gmail.com"),
                new User(103, "Milli", "pwd2", "milli@gmail.com"),
                new User(104, "Dom", "pwd3", "dom@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}