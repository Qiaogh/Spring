package com.qiaogh.domain;

public class Person {

    private String id;
    private String name;
    private Integer age;
    private String status;
    
    public Person( String id, String name, Integer age ) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
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
    public String getStatus() {
        return status;
    }
    public void setStatus( String status ) {
        this.status = status;
    }
}
