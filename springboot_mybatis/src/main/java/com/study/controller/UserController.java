package com.study.controller;

import com.github.pagehelper.Page;
import com.study.entity.User;
import com.study.mapper.UserMapper;
import com.study.page.PageEntity;
import com.study.param.UserParamQuery;
import com.study.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Author ytj
 * @Date 2021/3/10 16:13
 */
@RestController
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    private UserService  userService;

    @Resource
    private UserMapper userMapper;

    @GetMapping("/save")
    @ApiOperation("新增用户信息")
    public void save(){
        this.userService.save(User.builder().address("上海").age(18).name("张三").build());
    }

    @GetMapping("/update")
    @ApiOperation("修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id"),
            @ApiImplicitParam(name = "name",value = "姓名"),
            @ApiImplicitParam(name = "age",value = "年龄"),
            @ApiImplicitParam(name = "address",value = "地址"),
    })
    public void update(User user){
        this.userService.updateById(user);
    }

    @GetMapping("/select")
    @ApiOperation("查询用户信息")
    @ApiImplicitParam(name = "id",value = "id")
    public User select(String id){
        User user=this.userService.getById(id);
        return user;
    }

    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Object page(@Validated UserParamQuery  userParamQuery){
        Page<User> page=userParamQuery.create();
        this.userMapper.page(userParamQuery.createParam());
        return PageEntity.builds(page);
    }


}
