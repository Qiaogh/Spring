package com.qiaogh.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonServiceAspect {

    @Pointcut( "execution(* get(..))" )
    public void doGetPointcut() {}
}
