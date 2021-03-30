package com.study.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.study.entity.User;
import com.study.config.DBConstants;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author ytj
 * @Date 2021/3/30 10:11
 */
@Repository
@DS(DBConstants.DATASOURCE_USERS)
public interface UserMapper {

    User selectById(@Param("id")Integer id);
}
