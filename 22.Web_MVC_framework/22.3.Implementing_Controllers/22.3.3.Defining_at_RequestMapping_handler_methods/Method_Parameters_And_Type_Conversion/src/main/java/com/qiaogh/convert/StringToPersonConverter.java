package com.qiaogh.convert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiaogh.domain.Person;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToPersonConverter implements Converter<String, Person> {

    @Override
    public Person convert( String s ) {
        Validate.isTrue( StringUtils.isNotEmpty( s ), "用户信息不可为空！" );
        JSONObject json = JSON.parseObject( s );
        Person person = new Person();
        person.setName( json.getString( "name" ) );
        person.setAge( json.getInteger( "age" ) );
        return person;
    }
}
