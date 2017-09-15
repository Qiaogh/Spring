package com.qiaogh.aspect.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.qiaogh.introductions.PersonServiceIntroduction;
import com.qiaogh.introductions.impl.PersonServiceIntroductionImpl;

@Aspect
@Component
public class PersonServiceAspectImpl {

    @DeclareParents( value = "com.qiaogh.service.impl.PersonServiceImpl", defaultImpl = PersonServiceIntroductionImpl.class )
    private PersonServiceIntroduction personServiceIntroduction;
    
    
}
