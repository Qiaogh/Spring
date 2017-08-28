package com.qiaogh.convert;

import org.springframework.core.convert.converter.Converter;

import com.qiaogh.domain.Person;

public class StringToPersonConverter implements Converter<String, Person> {

    @Override
    public Person convert( String source ) {
        return new Person( source );
    }

}
