package com.qiaogh.resolver;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;

import com.qiaogh.factory.QiaoghFactoryBean;

public class SimpleBeanResolver implements BeanResolver {
    
    private GenericApplicationContext beanFactory = new GenericApplicationContext();
    
    {
        BeanDefinition beanDefinition = new RootBeanDefinition( QiaoghFactoryBean.class );
        beanFactory.registerBeanDefinition( "qiaogh", beanDefinition );
        beanFactory.refresh();
    }

    @Override
    public Object resolve( EvaluationContext context, String beanName ) throws AccessException {
        return beanFactory.getBean( beanName );
    }
}
