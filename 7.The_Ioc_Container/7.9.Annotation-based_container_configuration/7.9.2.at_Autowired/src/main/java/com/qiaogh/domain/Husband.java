package com.qiaogh.domain;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Husband {

    private String id;
    private String name;
    private Integer age;
    private Wife wife;
    private List<Wife> wifes;
    private Map<String, Wife> wifesMap;

    @Autowired
    public Husband( Wife wife ) {
        this.wife = wife;
    }
    public String getId() {
        return id;
    }
    @Value( "1" )
    public void setId( String id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @Value( "Qiaogh" )
    public void setName( String name ) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    @Value( "26" )
    public void setAge( Integer age ) {
        this.age = age;
    }
    public Wife getWife() {
        return wife;
    }
    public void setWife( Wife wife ) {
        this.wife = wife;
    }
    public List<Wife> getWifes() {
        return wifes;
    }
    @Autowired
    public void setWifes( List<Wife> wifes ) {
        this.wifes = wifes;
    }
    public Map<String, Wife> getWifesMap() {
        return wifesMap;
    }
    @Autowired
    public void setWifesMap( Map<String, Wife> wifesMap ) {
        this.wifesMap = wifesMap;
    }
}
