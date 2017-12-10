package com.qiaogh.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

public class User {

    public interface Json {}

    @JsonView( Json.class )
    private String name;
    @JsonView( Json.class )
    private String password;
    @JsonView( Json.class )
    private String age;
    @JsonView( Json.class )
    @JsonFormat( timezone = "GMT+8", pattern = "yyyy-MM-dd" )
    private Date brithday;

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

    public String getAge() {
        return age;
    }

    public void setAge( String age ) {
        this.age = age;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday( Date brithday ) {
        this.brithday = brithday;
    }
}
