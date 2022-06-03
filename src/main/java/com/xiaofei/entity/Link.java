package com.xiaofei.entity;

import javax.persistence.*;

/**
 * Author: xiaofei
 * Date: 2022-05-22, 13:25
 * Description:
 */
@Entity
@Table (name = "t_link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;  //linked name
    @Column
    private String url;   //linked url
    @Column
    private Integer sort;  //link order
    @Column
    private String remark; // link description

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
