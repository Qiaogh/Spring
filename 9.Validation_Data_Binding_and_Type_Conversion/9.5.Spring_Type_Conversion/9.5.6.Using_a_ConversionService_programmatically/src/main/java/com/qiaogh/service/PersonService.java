package com.qiaogh.service;

import java.util.List;

import com.qiaogh.domain.Person;

public interface PersonService {

    List<Person> find( String name );
}
