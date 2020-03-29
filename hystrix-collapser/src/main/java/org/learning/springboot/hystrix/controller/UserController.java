package org.learning.springboot.hystrix.controller;

import org.learning.springboot.hystrix.entity.User;
import org.learning.springboot.hystrix.server.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static AtomicLong atomicLong = new AtomicLong(1);

    @Autowired
    private IUserService userService;

    @GetMapping("/get")
    public User get() {
        return userService.getById(atomicLong.getAndIncrement());
    }
}
