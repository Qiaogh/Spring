package com.qiaogh.service.impl;

import com.qiaogh.domain.Person;
import com.qiaogh.service.SimpleExceptionPersonService;

public class SimpleExceptionPersonServiceImpl extends PersonServiceImpl implements SimpleExceptionPersonService {

    @Override
    public void exUpdate( Person person ) {
        update( person );
        throw new RuntimeException( "未知错误！" );
    }
    
    @Override
    public void exDelete( Integer id ) {
        delete( id );
        throw new RuntimeException( "未知错误！" );
    }
}
