package com.qiaogh.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AppTestConfig {

    @Bean
    public PlatformTransactionManager transactionManager( DataSource dataSource ) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource( dataSource );
        return transactionManager;
    }

//    @Bean
//    public SQLErrorCodes MySQL() {
//        return new SQLErrorCodes();
//    }
}
