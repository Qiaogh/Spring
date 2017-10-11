package com.qiaogh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.qiaogh.domain.Account;
import com.qiaogh.domain.Person;

@Configuration
@Import({
    Person.class,
    Account.class
})
public class AppConfig {

}
