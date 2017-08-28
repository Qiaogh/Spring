package com.qiaogh.convert;

import org.springframework.core.convert.converter.Converter;

import com.qiaogh.domain.Daughter;

public class StringToDaughterConverter implements Converter<String, Daughter> {

    @Override
    public Daughter convert( String source ) {
        return new Daughter( source );
    }

}
