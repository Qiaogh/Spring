package com.qiaogh.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;

public class Man {

    private String id;
    private String name;
    private Integer age;
    private Women wife;
    public String getId() {
        return id;
    }
    @Value( "${qiaogh.id}" )
    public void setId( String id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @Value( "${qiaogh.name}" )
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    @Value( "${qiaogh.age}" )
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Women getWife() {
        return wife;
    }
    @Resource
    public void setWife( Women wife ) {
        this.wife = wife;
    }
    @Override
    public String toString() {
        return "Man [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
