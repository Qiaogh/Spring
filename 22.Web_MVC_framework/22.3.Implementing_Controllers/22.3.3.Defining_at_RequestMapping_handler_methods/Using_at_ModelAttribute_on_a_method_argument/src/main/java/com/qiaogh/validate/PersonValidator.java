package com.qiaogh.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.qiaogh.domain.Person;

public class PersonValidator implements Validator {

    private static int MIN_AGE = 0;
    private static int MAX_AGE = 100;
    
    @Override
    public boolean supports( Class<?> clazz ) {
        return Person.class.isAssignableFrom( clazz );
    }

    @Override
    public void validate( Object target, Errors errors ) {
        ValidationUtils.rejectIfEmpty( errors, "name", "person.empty.name" );
        ValidationUtils.rejectIfEmpty( errors, "age", "person.empty.age" );
        
        Integer age = (Integer) errors.getFieldValue( "age" );
        if ( age < MIN_AGE || age > MAX_AGE ) {
            errors.reject( "person.error.age", new Object[] { MIN_AGE, MAX_AGE }, "输入的年龄有误！" );
        }
    }
}
