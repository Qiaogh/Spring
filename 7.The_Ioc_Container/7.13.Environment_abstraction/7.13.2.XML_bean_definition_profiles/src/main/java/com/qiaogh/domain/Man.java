package com.qiaogh.domain;


public class Man {

    private String id;
    private String name;
    private Integer age;
    private Women wife;
    
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
    public Women getWife() {
        return wife;
    }
    public void setWife( Women wife ) {
        this.wife = wife;
    }
}
