package com.qiaogh.domain;


public class Women {

    private String id;
    private String name;
    private Integer age;
    private Man husband;

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

    public Man getHusband() {
        return husband;
    }

    public void setHusband( Man husband ) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Women [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
