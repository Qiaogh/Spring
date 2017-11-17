package com.qiaogh.config;

import java.sql.Types;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcCallOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;

@Configuration
@ComponentScan( "com.qiaogh" )
@PropertySource( "jdbc.properties" )
public class AppConfig {

    private static final String TABLE_NAME = "persons";
    
    private static final String PROC_GET_PERSON = "get_person";
    
    private static final String FUN_GET_PERSON_NAME = "get_person_name";

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
    
    @Bean
    public SimpleJdbcInsertOperations jdbcInsertOperations( DataSource dataSource ) {
        return new SimpleJdbcInsert( dataSource ).withTableName( TABLE_NAME )
                .usingGeneratedKeyColumns( "id" );
    }

    @Bean
    public SimpleJdbcCallOperations getJdbcCallOperations( DataSource dataSource ) {
        return new SimpleJdbcCall( dataSource ).withProcedureName( PROC_GET_PERSON )
                .useInParameterNames( "in_id" )
                .declareParameters(
                        new SqlParameter( "in_id", Types.NUMERIC ),
                        new SqlOutParameter( "out_name", Types.VARCHAR ),
                        new SqlOutParameter( "out_age", Types.NUMERIC ) );
    }

    @Bean
    public SimpleJdbcCallOperations getNameJdbcCallOperations( DataSource dataSource ) {
        return new SimpleJdbcCall( dataSource ).withFunctionName( FUN_GET_PERSON_NAME )
                .useInParameterNames( "in_id" );
    }
}
