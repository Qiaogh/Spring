package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Value;

import com.qiaogh.annotation.Member;

@Member
public class Daughter {

    private String id;
    private String name;
    private Integer age;
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
    @Value( "Qiaoxh" )
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    @Value( "12" )
    public void setAge( Integer age ) {
        this.age = age;
    }
}
