package com.qiaogh.domain;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import com.qiaogh.util.StatusConstant;

public class Person implements InitializingBean, DisposableBean, StatusConstant {

    private static int START_INDEX = 1;
    private static int STOP_INDEX = 1;

    @Value( "1" )
    private String id;
    @Value( "Qiaogh" )
    private String name;
    private String annotatedStatus;
    private String interfacedStatus;
    private String javaConfedStatus;
    private String xmlBesedStatus;
    private Map<String, Integer> startSeq = new HashMap<String, Integer>( 4 );
    private Map<String, Integer> stopSeq = new HashMap<String, Integer>( 4 );
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
    public String getAnnotatedStatus() {
        return annotatedStatus;
    }
    public void setAnnotatedStatus( String annotatedStatus ) {
        this.annotatedStatus = annotatedStatus;
    }
    public String getInterfacedStatus() {
        return interfacedStatus;
    }
    public void setInterfacedStatus( String interfacedStatus ) {
        this.interfacedStatus = interfacedStatus;
    }
    public String getJavaConfedStatus() {
        return javaConfedStatus;
    }
    public void setJavaConfedStatus( String javaConfedStatus ) {
        this.javaConfedStatus = javaConfedStatus;
    }
    public String getXmlBesedStatus() {
        return xmlBesedStatus;
    }
    public void setXmlBesedStatus( String xmlBesedStatus ) {
        this.xmlBesedStatus = xmlBesedStatus;
    }
    public Map<String, Integer> getStartSeq() {
        return startSeq;
    }
    public Map<String, Integer> getStopSeq() {
        return stopSeq;
    }
    @PostConstruct
    public void postConstruct() {
        setAnnotatedStatus( POST_CONSTRUCT );
        getStartSeq().put( POST_CONSTRUCT, START_INDEX++ );
    }
    
    @PreDestroy
    public void preDestroy() {
        setAnnotatedStatus( PRE_DESTROY );
        getStopSeq().put( PRE_DESTROY, STOP_INDEX++ );
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        setInterfacedStatus( AFTER_PROPERTIES_SET );
        getStartSeq().put( AFTER_PROPERTIES_SET, START_INDEX++ );
    }
    @Override
    public void destroy() throws Exception {
        setInterfacedStatus( DESTROY );
        getStopSeq().put( DESTROY, STOP_INDEX++ );
    }
    public void init() {
        setXmlBesedStatus( INIT );
        getStartSeq().put( INIT, START_INDEX++ );
    }
    public void free() {
        setXmlBesedStatus( FREE );
        getStopSeq().put( FREE, STOP_INDEX++ );
    }
}
