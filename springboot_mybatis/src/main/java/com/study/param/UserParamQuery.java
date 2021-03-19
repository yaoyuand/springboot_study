package com.study.param;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.study.page.BasePage;
import com.study.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ytj
 * @Date 2021/3/18 15:50
 */
@Data
@ApiModel("用户分页查询条件")
public class UserParamQuery extends BasePage<User> {
    @ApiModelProperty("姓名")
    private String name;

    public Map<String,Object> createParam(){
        Map<String,Object> map=new HashMap<>();
        if(StringUtils.isNotBlank(name)){
            map.put("name","%name%");
        }
        return map;
    }
}
