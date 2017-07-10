package com.qiaogh.domain;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Value;

@Named( "qiaogh" )
public class Man {

    private String id;
    private String name;
    private Integer age;
    private Provider<Women> wife;
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
    public Provider<Women> getWife() {
        return wife;
    }
    @Inject
    @Named( "qiy" )
    public void setWife( Provider<Women> wife ) {
        this.wife = wife;
    }
    @Override
    public String toString() {
        return "Man [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
