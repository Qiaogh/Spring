package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Class {
    
    @Autowired
    private Teacher teacher;
    
    public String play() {
        return teacher.process();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher( Teacher teacher ) {
        this.teacher = teacher;
    }
}
