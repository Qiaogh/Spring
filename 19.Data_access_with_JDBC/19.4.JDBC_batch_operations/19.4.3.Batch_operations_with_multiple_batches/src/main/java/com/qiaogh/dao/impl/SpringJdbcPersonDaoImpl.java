package com.qiaogh.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;
import com.qiaogh.util.ArrayUtils;

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
    
    private JdbcOperations jdbcTemplate;

    @Override
    public int count() {
        return this.jdbcTemplate.queryForObject( "select count(*) from persons", Integer.class );
    }

    @Override
    public void save( Person person ) {
        int result = this.jdbcTemplate.update( "insert into persons(name, age) values (?, ?)", person.getName(), person.getAge() );
        Validate.isTrue( result == 1, "保存人员信息失败！" );
    }
    
    @Override
    public void save( List<Person> persons ) {
        int[][] results = this.jdbcTemplate.batchUpdate( "insert into persons(name, age) values (?, ?)", persons, 10, new ParameterizedPreparedStatementSetter<Person>() {
            @Override
            public void setValues( PreparedStatement ps, Person person ) throws SQLException {
                ps.setString( 1, person.getName() );
                ps.setInt( 2, person.getAge() );
            }
        });
        Validate.isTrue( ArrayUtils.size( results ) == persons.size(), "保存人员信息失败！" );
        for ( int i = 0; i < results.length; i++ ) {
            for ( int j = 0; j < results[i].length; j++ ) {
                Validate.isTrue( results[i][j] == 1, "保存人员信息失败！" );
            }
        }
    }

    @Override
    public void delete( Integer id ) {
        int result = this.jdbcTemplate.update( "delete from persons where id = ?", id );
        Validate.isTrue( result == 1, "删除人员信息失败！" );
    }

    @Override
    public void update( Person person ) {
        int result = this.jdbcTemplate.update( "update persons set name = ?, age = ? where id = ?", person.getName(), person.getAge(), person.getId() );
        Validate.isTrue( result == 1, "更新人员信息失败！" );
    }
    
    @Override
    public void update( List<Person> persons ) {
        int[][] results = this.jdbcTemplate.batchUpdate( "update persons set name = ?, age = ? where id = ?", persons, 10, new ParameterizedPreparedStatementSetter<Person>() {
            @Override
            public void setValues( PreparedStatement ps, Person person ) throws SQLException {
                ps.setString( 1, person.getName() );
                ps.setInt( 2, person.getAge() );
                ps.setInt( 3, person.getId() );
            }
        });
        Validate.isTrue( ArrayUtils.size( results ) == persons.size(), "更新人员信息失败！" );
        for ( int i = 0; i < results.length; i++ ) {
            for ( int j = 0; j < results[i].length; j++ ) {
                Validate.isTrue( results[i][j] == 1, "更新人员信息失败！" );
            }
        }
    }

    @Override
    public Person get( Integer id ) {
        return this.jdbcTemplate.queryForObject( "select id, name, age from persons where id = ?", new Object[] { id }, ROW_MAPPER.get() );
    }

    @Override
    public List<Person> query() {
        return this.jdbcTemplate.query( "select id, name, age from persons", ROW_MAPPER.get() );
    }
    
    public JdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate( JdbcOperations jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
