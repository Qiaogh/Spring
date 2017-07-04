package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {

    private String id;
    private String name;
    private String age;
    
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
    @Required
    @Value( "Qiaogh" )
    public void setName( String name ) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    @Value( "25" )
    public void setAge( String age ) {
        this.age = age;
    }
}
