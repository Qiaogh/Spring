package com.qiaogh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.qiaogh.factory.ManFactory;
import com.qiaogh.factory.WomenFactory;

@Configuration
@Import({
    ManFactory.class,
    WomenFactory.class
})
public class AppConfig {

}
