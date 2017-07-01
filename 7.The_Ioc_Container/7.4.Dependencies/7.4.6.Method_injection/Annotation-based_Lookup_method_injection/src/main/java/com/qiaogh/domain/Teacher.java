package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class Teacher {

    public String process() {
        Student student = callNextStudent();
        return student.sing();
    }
    
    @Lookup
    protected abstract Student callNextStudent();
}
