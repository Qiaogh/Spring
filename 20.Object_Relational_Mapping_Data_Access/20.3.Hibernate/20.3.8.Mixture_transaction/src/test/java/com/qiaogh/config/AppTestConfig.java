package com.qiaogh.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AppTestConfig {

    @Bean
    public PlatformTransactionManager transactionManager( SessionFactory sessionFactory ) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory( sessionFactory );
        return transactionManager;
    }
}
