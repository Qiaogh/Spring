package com.qiaogh.domain;

import com.qiaogh.annotation.Keyword;

public class Son {

    private String id;
    private String name;
    private Integer age;
    private Man father;
    private Women mother;
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
    public Man getFather() {
        return father;
    }
    public void setFather( Man father ) {
        this.father = father;
    }
    public Women getMother() {
        return mother;
    }
    @Keyword( "qiy" )
    public void setMother( Women mother ) {
        this.mother = mother;
    }
}
