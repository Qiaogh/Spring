package com.qiaogh.config;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyEditor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import sun.beans.editors.ColorEditor;
import sun.beans.editors.FontEditor;
import sun.beans.editors.ShortEditor;

import com.qiaogh.domain.Person;
import com.qiaogh.domain.Son;
import com.qiaogh.editors.SexEnumEditor;
import com.qiaogh.editors.SimpleCustomDateEditor;
import com.qiaogh.editors.SimpleStringTrimmerEditor;
import com.qiaogh.editors.SonEditor;
import com.qiaogh.util.Sex;

@Configuration
@Import({
    Person.class
})
public class AppConfig {

    @Bean
    public static CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditors = buildPropertyEditors();
        configurer.setCustomEditors( propertyEditors );
        return configurer;
    }
    
    private static Map<Class<?>, Class<? extends PropertyEditor>> buildPropertyEditors() {
        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditors = new HashMap<Class<?>, Class<? extends PropertyEditor>>();
        propertyEditors.put( Date.class, SimpleCustomDateEditor.class );
        propertyEditors.put( String.class, SimpleStringTrimmerEditor.class );
        propertyEditors.put( Short.class, ShortEditor.class );
        propertyEditors.put( Color.class, ColorEditor.class );
        propertyEditors.put( Sex.class, SexEnumEditor.class );
        propertyEditors.put( Font.class, FontEditor.class );
        propertyEditors.put( Son.class, SonEditor.class );
        return propertyEditors;
    }
}
