package com.qiaogh.config;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

public class SimpleBeanNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    public String generateBeanName( BeanDefinition definition, BeanDefinitionRegistry registry ) {
        if ( definition instanceof AnnotatedBeanDefinition ) {
            String beanName = determineBeanNameFromAnnotation( (AnnotatedBeanDefinition) definition );
            if ( StringUtils.hasText( beanName ) ) {
                return beanName;
            }
        }

        return genDefaultBeanName( definition );
    }

    private String genDefaultBeanName( BeanDefinition definition ) {
        return ClassUtils.getShortName( definition.getBeanClassName() );
    }
}
