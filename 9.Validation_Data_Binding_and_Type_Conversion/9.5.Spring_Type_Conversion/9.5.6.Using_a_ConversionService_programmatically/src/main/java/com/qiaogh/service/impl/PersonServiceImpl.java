package com.qiaogh.service.impl;

import java.util.List;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

public class PersonServiceImpl implements PersonService {

    private ConversionService conversionService;

    @SuppressWarnings( "unchecked" )
    @Override
    public List<Person> find( String names ) {
        return (List<Person>) conversionService.convert( names, TypeDescriptor.valueOf( String.class ), TypeDescriptor.collection( List.class, TypeDescriptor.valueOf( Person.class ) ) );
    }

    public ConversionService getConversionService() {
        return conversionService;
    }

    public void setConversionService( ConversionService conversionService ) {
        this.conversionService = conversionService;
    }
}
