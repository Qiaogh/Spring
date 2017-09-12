package com.qiaogh.service;

import com.qiaogh.domain.Identify;

public interface GenericService<T extends Identify> {

    T get( String id );
    
    void update( T t );
}
