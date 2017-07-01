package com.qiaogh.domain;

public class Person {

    private String id;
    private String name;
    private Person wife;

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

    public Person getWife() {
        return wife;
    }

    public void setWife( Person wife ) {
        this.wife = wife;
    }

}
