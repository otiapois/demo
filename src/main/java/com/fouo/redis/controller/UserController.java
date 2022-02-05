package com.fouo.redis.controller;

import com.fouo.redis.entity.User;
import com.fouo.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@RequestBody User user) {
        userService.saveUser(user);
        return "suceess";
    }

}
