package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Son {

    private String id;
    private String name;
    private Integer age;
    private Monk father;
    public String getId() {
        return id;
    }
    @Value( "4" )
    public void setId( String id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @Value( "Shangming" )
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
    public Monk getFather() {
        return father;
    }
    @Autowired( required = false )
    public void setFather( Monk father ) {
        this.father = father;
    }
}
