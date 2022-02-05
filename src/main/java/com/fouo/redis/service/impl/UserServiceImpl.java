package com.fouo.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fouo.redis.entity.User;
import com.fouo.redis.mapper.UserMapper;
import com.fouo.redis.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    public static final String USER_KEY = "user:";
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void saveUser(User user) {
        Gson gson = new Gson();
        user.setCreateTime(new Date());
        int id = baseMapper.insert(user);
        if (id > 0) {
            User userBean = getById(user.getId());
            if (userBean != null) {
                redisTemplate.boundValueOps(USER_KEY + id).set(userBean);
            }

        }
    }
}
