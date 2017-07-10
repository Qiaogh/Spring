package com.qiaogh.config.scope;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.context.annotation.ScopedProxyMode;

public class SimpleScopeMetadataResolver implements ScopeMetadataResolver {

    @Override
    public ScopeMetadata resolveScopeMetadata( BeanDefinition definition ) {
        ScopeMetadata scopeMetadata = new ScopeMetadata();
        if ( definition instanceof AnnotatedBeanDefinition ) {
            scopeMetadata.setScopeName( "singleton" );
            scopeMetadata.setScopedProxyMode( ScopedProxyMode.NO );
        }
        return scopeMetadata;
    }
}
