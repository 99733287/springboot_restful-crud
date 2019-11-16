package com.ucpeo.springboot.bean;

import java.util.Date;

public class User {
    private Integer id;
    private String  name;
    private Integer sex;
    private Date createTime;
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User(Integer id, String name, Integer sex, Date createTime, Department department) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.createTime = createTime;
        this.department = department;
    }

    public User(){};

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", createTime=" + createTime +
                ", department=" + department +
                '}';
    }
}
