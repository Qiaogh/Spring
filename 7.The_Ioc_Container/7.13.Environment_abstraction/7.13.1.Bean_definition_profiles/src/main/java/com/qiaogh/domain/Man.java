package com.qiaogh.domain;

import javax.annotation.Resource;

public class Man {

    private String id;
    private String name;
    private Integer age;
    private Women wife;
    
    public Man( String id, String name, Integer age ) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public String getId() {
        return id;
    }
    public void setId( String id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
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
}
