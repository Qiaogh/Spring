package com.qiaogh.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.qiaogh.domain.Person;

@Configuration
@ComponentScan( "com.qiaogh" )
@PropertySource( "classpath:jdbc.properties" )
public class AppConfig {

    @Bean
    public DataSource dataSource( @Value( "${jdbc.driverClass}" ) String driverClassName,
                                  @Value( "${jdbc.url}" ) String url,
                                  @Value( "${jdbc.username}" ) String username,
                                  @Value( "${jdbc.password}" ) String password ) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName( driverClassName );
        dataSource.setUrl( url );
        dataSource.setUsername( username );
        dataSource.setPassword( password );
        return dataSource;
    }
    
    @Bean
    public JdbcOperations jdbcTemplate( DataSource dataSource ) {
        return new JdbcTemplate( dataSource );
    }

    @SuppressWarnings( "deprecation" )
    @Bean
    public SessionFactory sessionFactory( DataSource dataSource ) {
        return new LocalSessionFactoryBuilder( dataSource )
            .addAnnotatedClass( Person.class )
            .buildSessionFactory();
    }
}
