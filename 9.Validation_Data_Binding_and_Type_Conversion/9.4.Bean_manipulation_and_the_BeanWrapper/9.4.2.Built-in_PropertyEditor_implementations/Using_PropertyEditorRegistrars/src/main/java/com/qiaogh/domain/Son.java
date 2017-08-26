package com.qiaogh.domain;

public class Son extends Person {

    private String name;

    public Son( String name ) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son [name=" + name + "]";
    }
}
