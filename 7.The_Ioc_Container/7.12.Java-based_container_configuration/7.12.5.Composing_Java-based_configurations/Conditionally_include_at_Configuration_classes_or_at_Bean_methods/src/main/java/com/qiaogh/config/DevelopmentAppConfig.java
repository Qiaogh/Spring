package com.qiaogh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.qiaogh.domain.Man;

@Configuration
@Import({ Man.class })
@Profile({ "development" })
public class DevelopmentAppConfig {

}
