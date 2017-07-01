package com.qiaogh.domain;

public class Class {

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
