package com.qiaogh.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiaogh.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserConverter implements Converter<String, User> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    public User convert( String source ) {
        try {
            return OBJECT_MAPPER.readerFor( User.class ).readValue( source );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return null;
    }
}
