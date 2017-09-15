package com.qiaogh.introductions.impl;

import org.springframework.util.StringUtils;

import com.qiaogh.domain.Person;
import com.qiaogh.introductions.PersonServiceIntroduction;
import com.qiaogh.service.impl.PersonServiceImpl;

public class PersonServiceIntroductionImpl extends PersonServiceImpl implements PersonServiceIntroduction {

    @Override
    public boolean validate( Person person ) {
        return person != null && 
                !StringUtils.isEmpty( person.getId() ) &&
                !StringUtils.isEmpty( person.getName() ) &&
                person.getAge() != null &&
                person.getAge() > 0 &&
                person.getAge() < 120;
    }

}
