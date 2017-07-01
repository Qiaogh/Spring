package com.qiaogh.domain;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope( "prototype" )
public class Student {

    String seq = UUID.randomUUID().toString();
    
    public String sing() {
        return seq;
    }
}
