package com.qiaogh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCallOperations;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
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
    private SimpleJdbcInsertOperations jdbcInsert;
    private SimpleJdbcCallOperations getJdbcCall;

    @Override
    public int count() {
        return this.jdbcTemplate.queryForObject( "select count(*) from persons", Integer.class );
    }

    @Override
    public Integer save( Person person ) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource( person );
        return jdbcInsert.executeAndReturnKey( parameterSource ).intValue();
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
        SqlParameterSource in = new MapSqlParameterSource( "in_id", id );
        Map<String, Object> out = getJdbcCall.execute( in );
        
        Person person = new Person();
        person.setId( id );
        person.setName( String.valueOf( out.get( "out_name" ) ) );
        person.setAge( Integer.valueOf( String.valueOf( out.get( "out_age" ) ) ) );
        return person;
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

    public SimpleJdbcInsertOperations getJdbcInsert() {
        return jdbcInsert;
    }

    @Autowired
    public void setJdbcInsert( SimpleJdbcInsertOperations jdbcInsert ) {
        this.jdbcInsert = jdbcInsert.withTableName( TABLE_NAME )
                .usingGeneratedKeyColumns( "id" );
    }

    public SimpleJdbcCallOperations getGetJdbcCall() {
        return getJdbcCall;
    }

    @Autowired
    public void setGetJdbcCall( SimpleJdbcCallOperations getJdbcCall ) {
        this.getJdbcCall = getJdbcCall.withProcedureName( PROC_GET_PERSON );
    }
}
