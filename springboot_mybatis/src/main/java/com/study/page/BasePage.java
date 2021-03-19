package com.study.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页基础类
 * @Author ytj
 * @Date 2021/3/18 15:37
 */
@Data
public class BasePage<T> {

    /**
     * 默认页数
     * */
    private static Integer DEFAULT_NUM=1;
    /**
     * 默认每页条数
     * */
    private static Integer DEFAULT_SIZE=10;
    @ApiModelProperty("当前页")
    private Integer pageNum=DEFAULT_NUM;
    @ApiModelProperty("每页条数")
    private Integer pageSize=DEFAULT_SIZE;

    public Page<T> create(){
        return PageHelper.startPage(pageNum,pageSize);
    }
}
