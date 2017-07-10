package com.qiaogh.domain;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

public class Women {

    private String id;
    private String name;
    private Integer age;
    private Man husband;
    
    public Women( String name ) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    @Value( "2" )
    public void setId( String id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @Value( "Qiy" )
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    @Value( "24" )
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Man getHusband() {
        return husband;
    }
    @Inject
    @Named( "qiaogh" )
    public void setHusband( Man husband ) {
        this.husband = husband;
    }
    @Override
    public String toString() {
        return "Women [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
