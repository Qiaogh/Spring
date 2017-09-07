package com.qiaogh.domain;

public class Person {

    private String name;

    public Person( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
    
    public String introduce() {
        return String.format( "My name is %s", name );
    }
}
