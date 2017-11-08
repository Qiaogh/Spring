package com.qiaogh.service;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.qiaogh.domain.Person;
import com.qiaogh.jdbc.PersonRowMapper;

public interface PersonService {

    RowMapper<Person> ROW_MAPPER = new PersonRowMapper();
    
    void save( Person person );
    void update( Person person );
    void exUpdate( Person person );
    void delete( Integer id );
    void exDelete( Integer id );
    Person get( Integer id );
    List<Person> query();
}
