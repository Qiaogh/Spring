package com.qiaogh;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SimpleApplicationContextAware implements ApplicationContextAware {

    private static ApplicationContext CXT;
    
    @Override
    public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException {
        CXT = applicationContext;
    }
    
    public static Object getBean( String name ) {
        return CXT.getBean( name );
    }
    
    public static <T> T getBean( Class<T> requiredType ) {
        return CXT.getBean( requiredType );
    }

}
