package com.qiaogh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    CityProfile.class,
    VillageProfile.class,
    DefaultProfile.class
})
public class AppConfig {

}
