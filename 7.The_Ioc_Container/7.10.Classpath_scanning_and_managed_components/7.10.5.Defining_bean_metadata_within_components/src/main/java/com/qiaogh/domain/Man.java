package com.qiaogh.domain;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component( "qiaogh" )
@Primary
public class Man {

    private String id;
    private String name;
    private Integer age;
    private Women wife;
    private String wifeName;
    
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
    @Resource
    public void setWife( Women wife ) {
        this.wife = wife;
    }
    public String getWifeName() {
        return wifeName;
    }
    @Value( "#{qiy.name}" )
    public void setWifeName( String wifeName ) {
        this.wifeName = wifeName;
    }
}
