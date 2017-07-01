package com.qiaogh.domain;

import java.util.List;

public class Person {

    private String id;
    private String name;
    private List<String> childs;
    
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
    public List<String> getChilds() {
        return childs;
    }
    public void setChilds( List<String> childs ) {
        this.childs = childs;
    }
}
