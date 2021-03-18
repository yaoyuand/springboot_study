package com.study.page;


import com.github.pagehelper.Page;

import java.util.List;

/**
 * 分页实体
 * @Author ytj
 * @Date 2021/3/18 16:12
 */
public class PageEntity<T> {
    //当前页
    private Integer pageNum;
    //每页总条数
    private Integer pageSize;
    //总条数
    private Integer total;
    //总页数
    private Integer  pages;
    //数据
    private List<T> list;

    public static <T>PageEntity<T>  builds(Page<T> page){
        PageEntity<T> pageEntity=new PageEntity<>();
        pageEntity.setPageNum(page.getPageNum())
                .setPageSize(page.getPageSize())
                .setPages(page.getPages())
                .setTotal((int)page.getTotal())
                .setList(page.getResult());
        return pageEntity;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public PageEntity<T> setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public PageEntity<T> setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public PageEntity<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPages() {
        return pages;
    }

    public PageEntity<T> setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public List<T> getList() {
        return list;
    }

    public PageEntity<T> setList(List<T> list) {
        this.list = list;
        return  this;
    }
}
