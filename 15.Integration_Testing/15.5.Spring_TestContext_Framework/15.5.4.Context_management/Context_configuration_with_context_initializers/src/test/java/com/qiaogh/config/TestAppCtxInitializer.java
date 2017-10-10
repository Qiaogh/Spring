package com.qiaogh.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class TestAppCtxInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static boolean INVOKED = false;
    
    @Override
    public void initialize( ConfigurableApplicationContext applicationContext ) {
        INVOKED = true;
    }
}
