package com.xiaofei.entity;

import java.util.Objects;

/**
 * 分页Model类
 * @author java1234_小锋
 * @site www.java1234.com
 * @company Java知识分享网
 * @create 2020-02-16 上午 11:05
 */
public class PageBean {
    private int page; //start from which page
    private int pageSize; //page size in each page
    private int start; //starting point/index

    public PageBean() {
    }

    public PageBean(int page, int pageSize){
        this.page=page;
        this.pageSize=pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart(){
        return (page-1)*pageSize;
    }
}


