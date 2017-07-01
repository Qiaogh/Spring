package com.qiaogh.domain;

/**
 * Created by qiaogh on 2017/3/15.
 */
public class Person {

    private Integer id;
    private String name;
    private Person husband;
    private Person wife;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Person getHusband() {
        return husband;
    }

    public void setHusband( Person husband ) {
        this.husband = husband;
    }

    public Person getWife() {
        return wife;
    }

    public void setWife( Person wife ) {
        this.wife = wife;
    }
}
