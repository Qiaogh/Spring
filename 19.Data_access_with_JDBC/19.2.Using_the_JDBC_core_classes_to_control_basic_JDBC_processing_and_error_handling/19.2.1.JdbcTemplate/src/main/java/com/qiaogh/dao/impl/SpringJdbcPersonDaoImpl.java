package com.qiaogh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
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
    public int count() {
        return this.jdbcTemplate.queryForObject( "select count(*) from persons", Integer.class );
    }

    @Override
    public void save( Person person ) {
        int result = this.jdbcTemplate.update( "insert into persons(name, age) values (?, ?)", person.getName(), person.getAge() );
        Validate.isTrue( result == 1, "保存人员信息失败！" );
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
