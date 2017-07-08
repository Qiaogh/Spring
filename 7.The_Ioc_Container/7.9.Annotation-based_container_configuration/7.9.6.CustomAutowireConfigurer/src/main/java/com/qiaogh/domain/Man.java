package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qiaogh.annotation.Keyword;

@Component
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
    @Value( "24" )
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Women getWife() {
        return wife;
    }
    @Autowired
    @Keyword( "qiy" )
    public void setWife( Women wife ) {
        this.wife = wife;
    }
}
