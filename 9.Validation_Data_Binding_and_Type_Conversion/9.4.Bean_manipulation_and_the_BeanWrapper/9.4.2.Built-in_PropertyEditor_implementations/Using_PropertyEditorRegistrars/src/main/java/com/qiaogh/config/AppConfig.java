package com.qiaogh.config;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.qiaogh.domain.Person;
import com.qiaogh.editors.CustomPropertyEditorRegistrar;

@Configuration
@Import({
    Person.class
})
public class AppConfig {

    @Bean
    public static CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        configurer.setPropertyEditorRegistrars( new PropertyEditorRegistrar[] {
            new CustomPropertyEditorRegistrar()
        });
        return configurer;
    }
}
