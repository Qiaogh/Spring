package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Value;

// 下面的注释打开，Spring 将不使用 PersonFactoryBean 来创建实例。
//@Component
public class Person {

    @Value( "1" )
    private String id;
    @Value( "Qiaogh" )
    private String name;
    @Value( "25" )
    private Integer age;
    
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
}
