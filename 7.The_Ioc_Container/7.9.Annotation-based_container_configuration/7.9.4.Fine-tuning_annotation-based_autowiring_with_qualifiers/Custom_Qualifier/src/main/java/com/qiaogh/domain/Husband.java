package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qiaogh.annotation.Birthmark;
import com.qiaogh.annotation.Keyword;

@Component
public class Husband {

    private String id;
    private String name;
    private Integer age;
    private Wife wife;
    private Daughter qiaoxh;
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
    @Keyword( "qiy" )
    public void setWife( Wife wife ) {
        this.wife = wife;
    }
    public Daughter getQiaoxh() {
        return qiaoxh;
    }
    @Autowired
    @Birthmark
    public void setQiaoxh( Daughter qiaoxh ) {
        this.qiaoxh = qiaoxh;
    }
    @Override
    public String toString() {
        return "Husband [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
