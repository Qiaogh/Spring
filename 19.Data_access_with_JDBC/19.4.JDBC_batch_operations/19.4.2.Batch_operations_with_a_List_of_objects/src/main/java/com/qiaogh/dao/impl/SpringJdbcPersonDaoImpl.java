package com.qiaogh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;

@Repository
public class SpringJdbcPersonDaoImpl implements PersonDao {

    private static ThreadLocal<PersonRowMapper> ROW_MAPPER = new ThreadLocal<PersonRowMapper>() {
        protected PersonRowMapper initialValue() {
            return new PersonRowMapper();
        };
    };
    
    private static class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow( ResultSet rs, int rowNum ) throws SQLException {
            Person person = new Person();
            person.setId( rs.getInt( "id" ) );
            person.setName( rs.getString( "name" ) );
            person.setAge( rs.getInt( "age" ) );
            return person;
        }
    }
    
    private NamedParameterJdbcOperations jdbcTemplate;

    @Override
    public int count() {
        return this.jdbcTemplate.queryForObject( "select count(*) from persons", EmptySqlParameterSource.INSTANCE, Integer.class );
    }

    @Override
    public void save( Person person ) {
        int result = this.jdbcTemplate.update( "insert into persons(name, age) values (:name, :age)", new BeanPropertySqlParameterSource( person ) );
        Validate.isTrue( result == 1, "保存人员信息失败！" );
    }
    
    @Override
    public void save( List<Person> persons ) {
        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch( persons.toArray() );
        int[] results = this.jdbcTemplate.batchUpdate( "insert into persons(name, age) values (:name, :age)", batchArgs );
        Validate.isTrue( results.length == persons.size(), "保存人员信息失败！" );
        for ( int i = 0; i < results.length; i++ ) {
            Validate.isTrue( results[i] == 1, "保存人员信息失败！" );
        }
    }

    @Override
    public void delete( Integer id ) {
        int result = this.jdbcTemplate.update( "delete from persons where id = :id", Collections.singletonMap( "id", id ) );
        Validate.isTrue( result == 1, "删除人员信息失败！" );
    }

    @Override
    public void update( Person person ) {
        int result = this.jdbcTemplate.update( "update persons set name = :name, age = :age where id = :id", new BeanPropertySqlParameterSource( person ) );
        Validate.isTrue( result == 1, "更新人员信息失败！" );
    }

    @Override
    public void update( List<Person> persons ) {
        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch( persons.toArray() );
        int[] results = this.jdbcTemplate.batchUpdate( "update persons set name = :name, age = :age where id = :id", batchArgs );
        Validate.isTrue( results.length == persons.size(), "更新人员信息失败！" );
        for ( int i = 0; i < results.length; i++ ) {
            Validate.isTrue( results[i] == 1, "更新人员信息失败！" );
        }
    }
    
    @Override
    public Person get( Integer id ) {
        return this.jdbcTemplate.queryForObject( "select id, name, age from persons where id = :id", Collections.singletonMap( "id", id ), ROW_MAPPER.get() );
    }

    @Override
    public List<Person> query() {
        return this.jdbcTemplate.query( "select id, name, age from persons", ROW_MAPPER.get() );
    }
    
    public NamedParameterJdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate( NamedParameterJdbcOperations jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
