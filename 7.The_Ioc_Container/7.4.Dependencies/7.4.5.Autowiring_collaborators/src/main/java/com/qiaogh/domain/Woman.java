package com.qiaogh.domain;

public class Woman {

    private String id;
    private String name;
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
    public Man getHusband() {
        return husband;
    }
    public void setHusband( Man husband ) {
        this.husband = husband;
    }
}
