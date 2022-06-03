package com.xiaofei.entity;

import javax.persistence.*;

/**
 * Author: xiaofei
 * Date: 2022-05-24, 20:05
 * Description:
 */
@Entity
@Table (name = "t_menu")
public class Menu {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String url;
    @Column
    private String color;
    @Column
    private Boolean strong; //if 粗体 or not
    @Column
    private Integer sort;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getStrong() {
        return strong;
    }

    public void setStrong(Boolean strong) {
        this.strong = strong;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
