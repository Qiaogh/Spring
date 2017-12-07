package com.qiaogh.config;

import com.qiaogh.convert.StringToPersonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Set;

@Configuration
@EnableWebMvc
@ComponentScan( basePackages = "com.qiaogh", includeFilters = {
    @ComponentScan.Filter( type = FilterType.ANNOTATION, value = Controller.class )
})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    public void addFormatters( FormatterRegistry registry, StringToPersonConverter converter ) {
        registry.addConverter( converter );
        super.addFormatters( registry );
    }
}
