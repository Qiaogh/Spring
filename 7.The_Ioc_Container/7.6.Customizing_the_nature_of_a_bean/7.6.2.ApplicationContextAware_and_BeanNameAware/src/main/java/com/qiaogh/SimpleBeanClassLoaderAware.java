package com.qiaogh;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanClassLoaderAware implements BeanClassLoaderAware {

    private ClassLoader beanClassLoader;
    
    @Override
    public void setBeanClassLoader( ClassLoader classLoader ) {
        this.beanClassLoader = classLoader;
    }

    public ClassLoader getBeanClassLoader() {
        return beanClassLoader;
    }
}
