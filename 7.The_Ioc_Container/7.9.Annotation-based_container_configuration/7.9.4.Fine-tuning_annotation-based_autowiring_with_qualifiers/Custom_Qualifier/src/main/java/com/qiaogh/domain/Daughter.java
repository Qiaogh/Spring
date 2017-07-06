package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Daughter {

    private String id;
    private String name;
    private Integer age;
    private Husband husband;
    
    public Daughter( String name ) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    @Value( "3" )
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
    @Value( "11" )
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Husband getHusband() {
        return husband;
    }
    @Autowired
    public void setHusband( Husband husband ) {
        this.husband = husband;
    }
    @Override
    public String toString() {
        return "Daughter [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
