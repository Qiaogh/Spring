package com.qiaogh.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qiaogh.util.StatusConstant;

@Component
public class AnnotationedPerson implements StatusConstant {

    @Value( "1" )
    private String id;
    @Value( "Qiaogh" )
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
    public void afterPropertiesSet() {
        setStatus( AFTER_PROPERTIES_SET );
    }
    
    @PreDestroy
    public void destroy() {
        setStatus( DESTROY );
    }
}
