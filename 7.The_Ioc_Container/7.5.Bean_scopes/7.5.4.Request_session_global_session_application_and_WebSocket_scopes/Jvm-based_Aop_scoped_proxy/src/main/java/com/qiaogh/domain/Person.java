package com.qiaogh.domain;

public class Person implements IPerson {

    private String id;
    private String name;
    private IPerson request;
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
    public IPerson getRequest() {
        return request;
    }
    public void setRequest( IPerson request ) {
        this.request = request;
    }
}
