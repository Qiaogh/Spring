package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Daughter {

    private String id;
    private String name;
    private Integer age;
    private Husband parent;
    
    public Daughter( String name ) {
        this.name = name;
    }
    
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
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    @Value( "8" )
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Husband getParent() {
        return parent;
    }
    @Autowired
    public void setParent( Husband parent ) {
        this.parent = parent;
    }
    @Override
    public String toString() {
        return "Husband [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
