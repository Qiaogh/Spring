package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Women {

    private String id;
    private String name;
    private Integer age;
    private Man husband;
    
    public Women( String id, String name ) {
        this.id = id;
        this.name = name;
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
    @Value( "26" )
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Man getHusband() {
        return husband;
    }
    @Autowired
    public void setHusband( Man husband ) {
        this.husband = husband;
    }
}
