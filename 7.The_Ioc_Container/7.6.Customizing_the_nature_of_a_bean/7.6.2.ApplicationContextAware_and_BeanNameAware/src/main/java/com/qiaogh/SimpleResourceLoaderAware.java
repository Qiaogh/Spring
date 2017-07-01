package com.qiaogh;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class SimpleResourceLoaderAware implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;
    
    @Override
    public void setResourceLoader( ResourceLoader resourceLoader ) {
        this.resourceLoader = resourceLoader;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
