package com.qiaogh.advice;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice( "com.qiaogh.controller" )
public class DateFormatAdvice {

    @InitBinder
    public void initBinder( WebDataBinder binder ) {
        binder.addCustomFormatter( new DateFormatter( "yyyy-MM-dd" ) );
    }
}
