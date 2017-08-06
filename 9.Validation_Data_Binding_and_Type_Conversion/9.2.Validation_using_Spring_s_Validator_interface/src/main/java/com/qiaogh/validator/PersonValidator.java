package com.qiaogh.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.qiaogh.domain.Person;

public class PersonValidator implements Validator {

    @Override
    public boolean supports( Class<?> clazz ) {
        return Person.class.equals( clazz );
    }

    @Override
    public void validate( Object target, Errors errors ) {
        ValidationUtils.rejectIfEmpty( errors, "name", "name.empty" );
        Person p = (Person) target;
        if ( p.getAge() < 0 ) {
            errors.rejectValue( "age", "negativevalue", "年龄不能小于 0！" );
        } else if ( p.getAge() > 110 ) {
            errors.rejectValue( "age", "too.darn.old" );
        }
    }
}
