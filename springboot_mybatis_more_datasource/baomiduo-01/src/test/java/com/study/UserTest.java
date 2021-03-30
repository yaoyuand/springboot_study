package com.study;

import com.study.entity.User;
import com.study.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ytj
 * @Date 2021/3/30 10:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Baomiduo01Application.class)
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void select(){
        User user=this.userMapper.selectById(1);
        System.out.println(user);
    }
}
