package com.qiaogh.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan( "com.qiaogh" )
@ImportResource( locations = "classpath:applicationContext.xml" )
public class AppConfig {

    @Bean
    public JdbcOperations jdbcTemplate( DataSource dataSource ) {
        return new JdbcTemplate( dataSource );
    }
}
