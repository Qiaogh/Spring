package com.qiaogh.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.ThrowsAdvice;

import com.qiaogh.exceptions.CannotFindPersonException;

public class PersonServiceThrowsAdvice implements ThrowsAdvice {
    
    public static Map<String, Throwable> THROWED_EXCPTIONS = new HashMap<String, Throwable>();

    public void afterThrowing( IllegalArgumentException ex ) {
        THROWED_EXCPTIONS.put( ex.getClass().getName(), ex );
    }
    
    public void afterThrowing( CannotFindPersonException ex ) {
        THROWED_EXCPTIONS.put( ex.getClass().getName(), ex );
    }
}
