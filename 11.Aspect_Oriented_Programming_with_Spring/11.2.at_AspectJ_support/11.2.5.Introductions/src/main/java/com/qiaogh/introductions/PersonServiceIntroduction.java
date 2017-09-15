package com.qiaogh.introductions;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

public interface PersonServiceIntroduction extends PersonService {

    boolean validate( Person person );
}
