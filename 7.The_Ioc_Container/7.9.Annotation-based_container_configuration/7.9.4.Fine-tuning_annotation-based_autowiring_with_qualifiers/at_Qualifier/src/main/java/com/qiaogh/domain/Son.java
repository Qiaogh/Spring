package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Son {

    private String id;
    private String name;
    private Integer age;
    private Husband father;
    
    public Son( String name ) {
        this.name = name;
    }
    
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
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    @Value( "1" )
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Husband getFather() {
        return father;
    }
    @Autowired
    public void setFather( Husband father ) {
        this.father = father;
    }
}
