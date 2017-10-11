package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope( "request" )
public class Person {

    private String id;
    private String name;
    private Integer age;
    
    public String getId() {
        return id;
    }
    
    @Value( "#{request.getParameter( 'id' )}" )
    public void setId( String id ) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    @Value( "#{request.getParameter( 'name' )}" )
    public void setName( String name ) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }
    
    @Value( "#{request.getParameter( 'age' )}" )
    public void setAge( Integer age ) {
        this.age = age;
    }
}
