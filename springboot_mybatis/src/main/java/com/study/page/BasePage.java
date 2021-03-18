package com.study.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 分页基础类
 * @Author ytj
 * @Date 2021/3/18 15:37
 */
public class BasePage<T> {

    /**
     * 默认页数
     * */
    private static Integer DEFAULT_NUM=1;
    /**
     * 默认每页条数
     * */
    private static Integer DEFAULT_SIZE=10;
    private Integer pageNum=DEFAULT_NUM;

    private Integer pageSize=DEFAULT_SIZE;

    public Integer getPageNum(){
        return pageNum;
    }
    public void setPageNum(Integer pageNum){
        this.pageNum=pageNum;
    }

    public Integer getPageSize(){
        return pageSize;
    }

    public void setPageSize(Integer pageSize){
        this.pageSize=pageSize;
    }

    public Page<T> create(){
        return PageHelper.startPage(pageNum,pageSize);
    }
}
