package com.qiaogh.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "user" )
public class User {

    private String id;
    private String name;
    private String password;

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId( String id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName( String name ) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword( String password ) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
