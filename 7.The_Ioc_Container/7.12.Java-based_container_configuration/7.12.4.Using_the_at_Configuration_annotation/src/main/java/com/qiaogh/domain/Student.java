package com.qiaogh.domain;

import java.util.UUID;

public class Student {

    String seq = UUID.randomUUID().toString();
    
    public String sing() {
        return seq;
    }
}
