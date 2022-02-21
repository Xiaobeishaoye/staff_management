package com.example.service;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

public interface UserService {
    //用户注册
    void register(User user);
}
