package com.qiaogh.factory.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.qiaogh.domain.Person;

@Component( "person" )
public class PersonFactoryBean implements FactoryBean<Person> {

    public static String STATUS = null;
    public static String STATUS_OF_EXECUTED = "STATUS_OF_EXECUTED";
    
    @Override
    public Person getObject() throws Exception {
        STATUS = STATUS_OF_EXECUTED;
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
