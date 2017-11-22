package com.qiaogh.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan( "com.qiaogh" )
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
        .generateUniqueName( true )
        .setType( EmbeddedDatabaseType.HSQL )
        .setScriptEncoding( "UTF-8" )
        .ignoreFailedDrops( true )
        .addScript( "schema.sql" )
        .build();
    }

    @Bean
    public JdbcOperations jdbcTemplate( DataSource dataSource ) {
        return new JdbcTemplate( dataSource );
    }
}
