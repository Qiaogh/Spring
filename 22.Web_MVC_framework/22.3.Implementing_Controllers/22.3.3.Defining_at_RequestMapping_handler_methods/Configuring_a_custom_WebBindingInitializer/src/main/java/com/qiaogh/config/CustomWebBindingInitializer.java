package com.qiaogh.config;

import com.qiaogh.validate.PersonValidator;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomWebBindingInitializer implements WebBindingInitializer {

    @Override
    public void initBinder( WebDataBinder binder, WebRequest request ) {
        binder.addCustomFormatter( new DateFormatter( "yyyy-MM-dd" ) );
        binder.setValidator( new PersonValidator() );
    }
}
