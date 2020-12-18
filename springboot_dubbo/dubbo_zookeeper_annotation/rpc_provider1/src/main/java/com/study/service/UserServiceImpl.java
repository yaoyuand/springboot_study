package com.study.service;

import com.study.entity.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0")
@Component
public class UserServiceImpl implements UserService{

    @Override
    public List<User> selectAll() {
        System.out.println("服务提供者被调用");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        List<User> list=new ArrayList<>();
        list.add(new User(11,"张三","上海"));
        list.add(new User(12,"李四","北京"));
        list.add(new User(13,"王五","苏州"));
        return list;
    }
}
