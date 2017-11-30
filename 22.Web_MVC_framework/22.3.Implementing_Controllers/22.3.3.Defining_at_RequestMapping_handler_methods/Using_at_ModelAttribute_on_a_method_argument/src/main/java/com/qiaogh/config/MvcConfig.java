package com.qiaogh.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.bind.support.WebBindingInitializer;

import com.qiaogh.validate.PersonValidator;

@Configuration
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
    @ComponentScan.Filter( type = FilterType.ANNOTATION, value = Controller.class )
})
public class MvcConfig {
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename( "classpath:message.properties" );
        return messageSource;
    }
    
    @Bean
    public WebBindingInitializer mvcConfigurer() {
        ConfigurableWebBindingInitializer bindingInitializer = new ConfigurableWebBindingInitializer();
        bindingInitializer.setValidator( new PersonValidator() );
        return bindingInitializer;
    }
}
