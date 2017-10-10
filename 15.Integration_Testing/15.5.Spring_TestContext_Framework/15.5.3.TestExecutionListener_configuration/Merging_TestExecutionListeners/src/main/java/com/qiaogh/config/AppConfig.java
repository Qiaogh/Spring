package com.qiaogh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.qiaogh.domain.Person;

@Configuration
@Import( Person.class )
public class AppConfig {

}
