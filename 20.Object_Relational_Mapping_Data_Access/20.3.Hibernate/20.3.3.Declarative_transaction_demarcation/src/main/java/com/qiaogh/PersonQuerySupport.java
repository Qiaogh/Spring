package com.qiaogh;

import java.util.List;

import com.qiaogh.domain.Person;

public interface PersonQuerySupport {
    int count();
    Person get( Integer id );
    List<Person> query();
    List<Person> query( Integer... ids );
}
