package com.qiaogh.domain;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

@Named( "qiaogh" )
public class Man {

    private String id;
    private String name;
    private Integer age;
    private Women wife;
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
    public Women getWife() {
        return wife;
    }
    @Inject
    public void setWife( Women wife ) {
        this.wife = wife;
    }
    @Override
    public String toString() {
        return "Man [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
