package com.qiaogh.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization( Object bean, String beanName ) throws BeansException {
        System.out.println( "InstantiationTracingBeanPostProcessor postProcessBeforeInitialization " + beanName + "....." );
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization( Object bean, String beanName ) throws BeansException {
        System.out.println( "InstantiationTracingBeanPostProcessor postProcessAfterInitialization....." );
        return bean;
    }

}
