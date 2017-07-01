package com.qiaogh.domain;

import java.io.Closeable;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.qiaogh.util.StatusConstant;

@Component
public class JavaConfigPerson implements Closeable, StatusConstant {

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
    @Override
    public void close() throws IOException {
        setStatus( CLOSE );
    }
}
