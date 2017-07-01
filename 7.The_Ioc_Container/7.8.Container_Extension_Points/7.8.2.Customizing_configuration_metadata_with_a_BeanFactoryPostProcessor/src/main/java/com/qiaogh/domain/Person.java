package com.qiaogh.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.qiaogh.util.StatusConstant;

public class Person implements InitializingBean, DisposableBean, StatusConstant {

    private String id;
    private String name;
    private String status;
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
    public String getStatus() {
        return status;
    }
    public void setStatus( String status ) {
        this.status = status;
    }
    @PostConstruct
    @Override
    public void afterPropertiesSet() {
        setStatus( AFTER_PROPERTIES_SET );
    }
    
    @PreDestroy
    @Override
    public void destroy() {
        setStatus( DESTROY );
    }
    
}
