package com.qiaogh.dao;

import com.qiaogh.PersonPersistenceSupport;
import com.qiaogh.PersonQuerySupport;

public interface PersonDao extends PersonQuerySupport, PersonPersistenceSupport {

    String TABLE_NAME = "persons";
    
    String PROC_GET_PERSON = "get_person";
}
