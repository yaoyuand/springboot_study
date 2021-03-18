package com.study.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.entity.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author ytj
 * @Date 2021/3/10 16:09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
