package com.study.controller;

import com.github.pagehelper.Page;
import com.study.entity.User;
import com.study.mapper.UserMapper;
import com.study.page.PageEntity;
import com.study.param.UserParamQuery;
import com.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author ytj
 * @Date 2021/3/10 16:13
 */
@RestController
public class UserController {

    @Autowired
    private UserService  userService;

    @Resource
    private UserMapper userMapper;

    @GetMapping("/save")
    public void save(){
        this.userService.save(User.builder().address("上海").age(18).name("张三").build());
    }

    @GetMapping("/update")
    public void update(User user){
        this.userService.updateById(user);
    }

    @GetMapping("/select")
    public User select(String id){
        User user=this.userService.getById(id);
        return user;
    }

    @GetMapping("/page")
    public Object page(UserParamQuery  userParamQuery){
        Page<User> page=userParamQuery.create();
        this.userMapper.page(userParamQuery.createParam());
        return PageEntity.builds(page);
    }


}
