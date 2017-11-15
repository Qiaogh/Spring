package com.qiaogh.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.qiaogh.domain.Person;

public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow( ResultSet rs, int rowNum ) throws SQLException {
        Person person = new Person();
        person.setId( rs.getInt( "id" ) );
        person.setName( rs.getString( "name" ) );
        person.setAge( rs.getInt( "age" ) );
        return person;
    }

}
