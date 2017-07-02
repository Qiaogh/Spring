package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyOverrideConfigurerPerson {

    @Value( "10" )
    private String id;
    @Value( "QiaoQiao" )
    private String name;
    @Value( "29" )
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
