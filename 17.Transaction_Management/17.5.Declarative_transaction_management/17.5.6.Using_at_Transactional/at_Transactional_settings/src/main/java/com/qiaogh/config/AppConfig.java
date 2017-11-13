package com.qiaogh.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.qiaogh.service.MixturePersonService;
import com.qiaogh.service.NoTransactionPersonService;
import com.qiaogh.service.PersonService;
import com.qiaogh.service.ReadOnlyPersonService;
import com.qiaogh.service.TransactionPersonService;

@Configuration
@ImportResource( "classpath:spring-basic.xml" )
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public PersonService transactionPersonService( DataSource dataSource ) {
        return new TransactionPersonService( dataSource );
    }
    
    @Bean
    public PersonService noTransactionPersonService( DataSource dataSource ) {
        return new NoTransactionPersonService( dataSource );
    }
    
    @Bean
    public PersonService mixturePersonService( DataSource dataSource ) {
        return new MixturePersonService( dataSource );
    }
    
    @Bean
    public PersonService readOnlyPersonService( DataSource dataSource ) {
        return new ReadOnlyPersonService( dataSource );
    }
}
