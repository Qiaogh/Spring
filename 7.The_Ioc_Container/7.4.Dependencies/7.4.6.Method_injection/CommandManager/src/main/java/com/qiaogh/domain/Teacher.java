package com.qiaogh.domain;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Teacher implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    
    public String process() {
        Student student = callNextStudent();
        return student.sing();
    }
    
    private Student callNextStudent() {
        return applicationContext.getBean( Student.class );
    }
    
    @Override
    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
