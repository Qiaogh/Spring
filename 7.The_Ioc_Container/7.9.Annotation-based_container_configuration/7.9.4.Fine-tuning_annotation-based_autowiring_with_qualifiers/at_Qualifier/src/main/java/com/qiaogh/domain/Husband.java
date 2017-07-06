package com.qiaogh.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Husband {

    private String id;
    private String name;
    private Integer age;
    private Wife wife;
    private Son son;
    private Daughter daughter;
    
    public String getId() {
        return id;
    }
    @Value( "1" )
    public void setId( String id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @Value( "Qiaogh" )
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
    public Wife getWife() {
        return wife;
    }
    @Autowired
    @Qualifier( "qiy" )
    public void setWife( Wife wife ) {
        this.wife = wife;
    }
    public Son getSon() {
        return son;
    }
    @Autowired
    @Qualifier( "qiaoxl" )
    public void setSon( Son son ) {
        this.son = son;
    }
    public Daughter getDaughter() {
        return daughter;
    }
    @Resource( name = "qiaoxh" )
    public void setDaughter( Daughter daughter ) {
        this.daughter = daughter;
    }
    @Override
    public String toString() {
        return "Husband [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
