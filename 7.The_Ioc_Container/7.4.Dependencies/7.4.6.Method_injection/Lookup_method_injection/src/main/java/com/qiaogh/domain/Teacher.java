package com.qiaogh.domain;


public abstract class Teacher {

    public String process() {
        Student student = callNextStudent();
        return student.sing();
    }
    
    protected abstract Student callNextStudent();
}
