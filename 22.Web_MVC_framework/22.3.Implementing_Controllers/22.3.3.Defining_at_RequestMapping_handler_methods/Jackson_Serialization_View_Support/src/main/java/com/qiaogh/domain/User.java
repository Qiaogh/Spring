package com.qiaogh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

public class User {

    public interface WithoutPassword {}
    public interface All extends  WithoutPassword {}

    @JsonView( WithoutPassword.class )
    private String name;
    @JsonView( All.class )
    private String password;
    @JsonView( WithoutPassword.class )
    private Integer age;
    @JsonView( WithoutPassword.class )
    @JsonFormat( timezone = "GMT+8", pattern = "yyyy-MM-dd" )
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge( Integer age ) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday( Date birthday ) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
