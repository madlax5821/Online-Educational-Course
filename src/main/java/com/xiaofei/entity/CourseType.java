package com.xiaofei.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 0:07
 * Description:
 */
@Entity
@Table (name = "t_course_type")
public class CourseType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private Integer sort;
    @Column
    private String remark;
    @OneToMany (fetch = FetchType.LAZY,mappedBy = "courseType")
    private Set<Course> courses;

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

    public Set<Course> getCourses() {
        if (courses==null){
            courses = new HashSet<>();
        }
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course){
        this.getCourses().add(course);
        course.setCourseType(this);
    }

    public void removeCourse(Course course){
        course.setCourseType(null);
        this.getCourses().remove(course);
    }

    @Override
    public String toString() {
        return "CourseType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sort=" + sort +
                ", remark='" + remark + '\'' +
                '}';
    }
}
