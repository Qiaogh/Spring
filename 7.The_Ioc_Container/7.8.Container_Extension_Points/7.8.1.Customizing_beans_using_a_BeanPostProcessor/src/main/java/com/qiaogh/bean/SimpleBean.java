package com.qiaogh.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SimpleBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println( "SimpleBean afterPropertiesSet....." );
    }
}
