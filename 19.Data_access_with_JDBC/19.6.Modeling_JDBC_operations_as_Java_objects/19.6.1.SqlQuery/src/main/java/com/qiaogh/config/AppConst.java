package com.qiaogh.config;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import com.qiaogh.domain.Person;

public interface AppConst {

    RowMapper<Person> PERSON_ROW_MAPPER = BeanPropertyRowMapper.newInstance( Person.class );
    
    String SQL_GET_PERSON = "select id, name, age from persons where id = ?";
    
    String SQL_QUERY_PERSON = "select id, name, age from persons";
}
