package com.atguigu.admin.service;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangtao
 * @date 2022/5/26 - 20:34
 */
public interface UserService extends IService<User> {

    //public User getUserById(Long id);
}
