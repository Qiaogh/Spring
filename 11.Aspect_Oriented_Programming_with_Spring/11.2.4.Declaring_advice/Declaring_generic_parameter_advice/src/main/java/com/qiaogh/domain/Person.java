package com.qiaogh.domain;

public class Person extends Identify {

    private String name;
    private Integer age;
    
    public Person( String id, String name, Integer age ) {
        super( id );
        this.name = name;
        this.age = age;
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
}
