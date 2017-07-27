package com.qiaogh.domain;

import javax.annotation.Resource;

public class Women {

    private String id;
    private String name;
    private Integer age;
    private Man husband;
    
    public Women( String id, String name, Integer age ) {
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
    public Man getHusband() {
        return husband;
    }
    @Resource
    public void setHusband( Man husband ) {
        this.husband = husband;
    }
}
