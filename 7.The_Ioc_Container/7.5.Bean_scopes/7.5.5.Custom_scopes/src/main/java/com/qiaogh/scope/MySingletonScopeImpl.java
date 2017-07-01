package com.qiaogh.scope;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class MySingletonScopeImpl implements Scope {

    private Map<String, Object> objectMap = new HashMap<String, Object>();
    
    @Override
    public Object get( String name, ObjectFactory<?> objectFactory ) {
        if ( !objectMap.containsKey( name ) ) {
            objectMap.put( name, objectFactory.getObject() );
        }
        return objectMap.get( name );
    }

    @Override
    public Object remove( String name ) {
        return objectMap.remove( name );
    }

    @Override
    public void registerDestructionCallback( String name, Runnable callback ) {
        System.out.println( "registerDestructionCallback" );
    }

    @Override
    public Object resolveContextualObject( String key ) {
        System.out.println( "resolveContextualObject:" + key );
        return null;
    }

    @Override
    public String getConversationId() {
        System.out.println( "getConversationId:" );
        return null;
    }

}
