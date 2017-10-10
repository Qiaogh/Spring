package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component( "qiaogh" )
public class Person {

    private String id;
    private String name;
    private Integer age;
    private String from;
    
    public String getId() {
        return id;
    }
    
    @Value( "${qiaogh.id}" )
    public void setId( String id ) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    @Value( "${qiaogh.name}" )
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    
    @Value( "${qiaogh.age}" )
    public void setAge( Integer age ) {
        this.age = age;
    }

    public String getFrom() {
        return from;
    }

    @Value( "${qiaogh.from}" )
    public void setFrom( String from ) {
        this.from = from;
    }
}
