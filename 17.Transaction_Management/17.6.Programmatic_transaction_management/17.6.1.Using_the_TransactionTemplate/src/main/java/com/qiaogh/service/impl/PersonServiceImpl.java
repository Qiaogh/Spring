package com.qiaogh.service.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.jdbc.core.JdbcTemplate;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

public class PersonServiceImpl extends JdbcTemplate implements PersonService {

    @Override
    public void save( Person person ) {
        int result = update( "insert into persons ( name, age ) values ( ?, ? )", person.getName(), person.getAge() );
        Validate.isTrue( result == 1, "保存人员信息失败！" );
    }

    @Override
    public void update( Person person ) {
        int result = update( "update persons set name = ?, age = ? where id = ?", person.getName(), person.getAge(), person.getId() );
        Validate.isTrue( result == 1, "更新人员信息失败！" );
    }

    @Override
    public void delete( Integer id ) {
        int result = update( "delete from persons where id = ?", id );
        Validate.isTrue( result == 1, "删除人员信息失败!" );
    }

    @Override
    public Person get( Integer id ) {
        return queryForObject( "select id, name, age from persons where id = ?", new Object[] { id }, ROW_MAPPER );
    }

    @Override
    public List<Person> query() {
        return query( "select id, name, age from persons", ROW_MAPPER );
    }
}
