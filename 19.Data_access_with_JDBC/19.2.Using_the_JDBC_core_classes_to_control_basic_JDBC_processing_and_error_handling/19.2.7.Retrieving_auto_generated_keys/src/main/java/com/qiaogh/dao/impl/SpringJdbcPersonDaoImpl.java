package com.qiaogh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
    
    private JdbcOperations jdbcTemplate;

    @Override
    public Integer save( final Person person ) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = this.jdbcTemplate.update( new PreparedStatementCreator() {
            
            @Override
            public PreparedStatement createPreparedStatement( Connection con ) throws SQLException {
                PreparedStatement ps = con.prepareStatement( "insert into persons(name, age) values (?, ?)", new String[] { "id" } );
                ps.setString( 1, person.getName() );
                ps.setInt( 2, person.getAge() );
                return ps;
            }
        }, keyHolder );
        
        Validate.isTrue( result == 1, "保存人员信息失败！" );
        return keyHolder.getKey().intValue();
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
