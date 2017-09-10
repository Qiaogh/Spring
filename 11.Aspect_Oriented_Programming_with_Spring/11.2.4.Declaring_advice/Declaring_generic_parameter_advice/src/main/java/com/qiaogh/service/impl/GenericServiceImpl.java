package com.qiaogh.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.qiaogh.domain.Identify;
import com.qiaogh.exception.CannotFindObjectException;
import com.qiaogh.service.GenericService;

public class GenericServiceImpl<T extends Identify> implements GenericService<T> {

    protected Map<String, T> caches = new HashMap<String, T>();
    
    @Override
    public T get( String id ) {
        return caches.get( id );
    }

    @Override
    public void update( T t ) {
        Assert.notNull( t, "Updating object cannot be null!" );
        if ( !caches.containsKey( t.getId() ) ) {
            throw new CannotFindObjectException( t );
        }
        caches.put( t.getId(), t );
    }
}
