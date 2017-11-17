package com.qiaogh;

import java.util.List;

import com.qiaogh.domain.Person;

public interface PersonPersistenceSupport {
    void save( Person person );
    void save( List<Person> persons );
    void delete( Integer id );
    void update( Person person );
    void update( List<Person> persons );
}
