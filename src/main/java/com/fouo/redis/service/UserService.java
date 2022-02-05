package com.fouo.redis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fouo.redis.entity.User;

public interface UserService extends IService<User> {


    void saveUser(User user);
}
