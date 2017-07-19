package com.qiaogh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.qiaogh.domain.Student;
import com.qiaogh.domain.Teacher;

@Configuration
@ComponentScan( basePackages = "com.qiaogh" )
public class School {

    @Bean
    @Scope( "prototype" )
    public Student student() {
        return new Student();
    }
    
    @Bean
    public Teacher teacher() {
        return new Teacher() {
            @Override
            protected Student callNextStudent() {
                return student();
            }
        };
    }
    
    @Bean
    public com.qiaogh.domain.Class clazz() {
        com.qiaogh.domain.Class clazz = new com.qiaogh.domain.Class();
        clazz.setTeacher( teacher() );
        return clazz;
    }
}
