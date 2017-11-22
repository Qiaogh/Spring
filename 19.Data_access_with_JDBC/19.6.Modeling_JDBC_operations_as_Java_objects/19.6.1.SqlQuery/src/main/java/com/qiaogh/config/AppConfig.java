package com.qiaogh.config;

import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.jdbc.object.SqlQuery;

import com.qiaogh.domain.Person;

@Configuration
@ComponentScan( "com.qiaogh" )
@PropertySource( "jdbc.properties" )
public class AppConfig implements AppConst {
    
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
    public SqlQuery<Person> getSqlQuery( DataSource dataSource ) {
        return new SqlQuery<Person>( dataSource, SQL_GET_PERSON ) {
            
            @Override
            public void afterPropertiesSet() {
                this.declareParameter( new SqlParameter( Types.INTEGER ) );
            }

            @Override
            protected RowMapper<Person> newRowMapper( Object[] parameters, Map<?, ?> context ) {
                return PERSON_ROW_MAPPER;
            }
        };
    }

    @Bean
    public SqlQuery<Person> querySqlQuery( DataSource dataSource ) {
        return new SqlQuery<Person>( dataSource, SQL_QUERY_PERSON ) {

            @Override
            protected RowMapper<Person> newRowMapper( Object[] parameters, Map<?, ?> context ) {
                return PERSON_ROW_MAPPER;
            }
        };
    }
}
