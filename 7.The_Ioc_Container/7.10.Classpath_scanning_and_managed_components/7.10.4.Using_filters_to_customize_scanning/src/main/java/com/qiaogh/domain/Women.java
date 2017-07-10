package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Value;

import com.qiaogh.annotation.Member;

@Member
public class Women {

    private String id;
    private String name;
    private Integer age;
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
    @Override
    public String toString() {
        return "Women [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
