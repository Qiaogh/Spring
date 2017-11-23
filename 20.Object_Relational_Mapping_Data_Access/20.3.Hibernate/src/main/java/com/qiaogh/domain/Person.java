package com.qiaogh.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "persons" )
public class Person {

    private Integer id;
    private String name;
    private Integer age;
    private String data;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
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
    public Integer getAge() {
        return age;
    }
    public void setAge( Integer age ) {
        this.age = age;
    }
    public String getData() {
        return data;
    }
    public void setData( String data ) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", data=" + data + "]";
    }
}
