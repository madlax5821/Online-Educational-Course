package com.xiaofei.entity;

import javax.persistence.*;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 0:08
 * Description:
 */
@Entity
@Table(name = "t_course")
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column (name = "image_name")
    private String imageName;
    @Column
    private String type;  //vip, free, etc.
    @Column
    private Integer view;
    @Column
    private String introduction;
    @Column
    private String catalog;
    @Column
    private String download;
    @Column
    private String url;
    @Column
    private Boolean hktj=false;  //courses recommended, true or false
    @Column
    private Integer sort1; //order of hktj
    @Column
    private Boolean zxkc=false;  //new courses, true or false
    @Column
    private Integer sort2; //order of zxkc
    @Column
    private Boolean mfkc=false;  //free courses, true or false
    @Column
    private Integer sort3; //order of mfkc
    @Column
    private Boolean szkc=false;  //real project courses, true or false
    @Column
    private Integer sort4; //order of szkc
    @ManyToOne
    @JoinColumn(name = "type_id")
    private CourseType courseType;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getHktj() {
        return hktj;
    }

    public void setHktj(Boolean hktj) {
        this.hktj = hktj;
    }

    public Integer getSort1() {
        return sort1;
    }

    public void setSort1(Integer sort1) {
        this.sort1 = sort1;
    }

    public Boolean getZxkc() {
        return zxkc;
    }

    public void setZxkc(Boolean zxkc) {
        this.zxkc = zxkc;
    }

    public Integer getSort2() {
        return sort2;
    }

    public void setSort2(Integer sort2) {
        this.sort2 = sort2;
    }

    public Boolean getMfkc() {
        return mfkc;
    }

    public void setMfkc(Boolean mfkc) {
        this.mfkc = mfkc;
    }

    public Integer getSort3() {
        return sort3;
    }

    public void setSort3(Integer sort3) {
        this.sort3 = sort3;
    }

    public Boolean getSzkc() {
        return szkc;
    }

    public void setSzkc(Boolean szkc) {
        this.szkc = szkc;
    }

    public Integer getSort4() {
        return sort4;
    }

    public void setSort4(Integer sort4) {
        this.sort4 = sort4;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", type='" + type + '\'' +
                ", view=" + view +
                ", introduction='" + introduction + '\'' +
                ", catalog='" + catalog + '\'' +
                ", download='" + download + '\'' +
                ", url='" + url + '\'' +
                ", hktj=" + hktj +
                ", sort1=" + sort1 +
                ", zxkc=" + zxkc +
                ", sort2=" + sort2 +
                ", mfkc=" + mfkc +
                ", sort3=" + sort3 +
                ", szkc=" + szkc +
                ", sort4=" + sort4 +
                ", courseType=" + courseType +
                ", teacher=" + teacher +
                '}';
    }
}
