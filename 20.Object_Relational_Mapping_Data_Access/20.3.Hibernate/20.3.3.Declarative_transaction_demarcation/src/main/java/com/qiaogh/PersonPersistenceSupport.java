package com.qiaogh;

import com.qiaogh.domain.Person;

public interface PersonPersistenceSupport {
    Integer save( Person person );
    void delete( Integer id );
    void update( Person person );
}
