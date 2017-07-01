package com.qiaogh;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanNameAware implements BeanNameAware {

    private String beanName;
    
    @Override
    public void setBeanName( String beanName ) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
