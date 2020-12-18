package com.study.service;

import com.study.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public List<User> selectAll() {
        System.out.println("服务提供者被调用");
        List<User> list=new ArrayList<>();
        list.add(new User(11,"张三","上海"));
        list.add(new User(12,"李四","北京"));
        list.add(new User(13,"王五","苏州"));
        return list;
    }
}
