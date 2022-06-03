package com.xiaofei.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: xiaofei
 * Date: 2022-05-25, 0:08
 * Description:
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String username;
    @Column
    private String remark;
    @Column (name = "image_name")
    private String imageName;
    @OneToMany (fetch = FetchType.LAZY,mappedBy = "teacher")
    private Set<Course> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
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
        course.setTeacher(this);
    }
    
    public void removeCourse(Course course){
        course.setTeacher(null);
        this.getCourses().remove(course);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", remark='" + remark + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
