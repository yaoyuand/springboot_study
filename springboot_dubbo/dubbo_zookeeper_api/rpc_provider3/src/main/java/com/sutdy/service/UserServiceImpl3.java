package com.sutdy.service;

import com.study.entity.User3;
import com.study.service.UserService3;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Service
public class UserServiceImpl3 implements UserService3 {
    @Override
    public List<User3> selectAll() {
        System.out.println("执行服务提供方法");
        return Arrays.asList(new User3(11,"张三","上海"),new User3(12,"李四","北京"),new User3(13,"王五","苏州"));
    }
}
