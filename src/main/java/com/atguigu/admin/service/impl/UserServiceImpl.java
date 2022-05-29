package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangtao
 * @date 2022/5/27 - 8:10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;
//    @Override
//    public User getUserById(Long id) {
//
//        return userMapper.getUser(id);
//    }
}
