package com.study.mapper;

import com.study.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ytj
 * @Date 2021/3/30 10:11
 */
@Repository
public interface UserMapper {

    User selectById(@Param("id") Integer id);
}
