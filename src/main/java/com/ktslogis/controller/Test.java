package com.ktslogis.controller;

import com.ktslogis.entity.User;
import com.ktslogis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    UserRepository repository;

    @GetMapping
    public void testMethod(@RequestParam String un) {

        User user = repository.findByUsername(un);

        System.out.println(user);

    }
}
