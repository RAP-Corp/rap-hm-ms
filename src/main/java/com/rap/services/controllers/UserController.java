package com.rap.services.controllers;

import com.rap.services.models.User;
import com.rap.services.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRespository userRespository;

    @GetMapping
    public Flux<User> index() {
        return userRespository.findAll();
    }
}
