package com.qiaogh.advice;

import com.qiaogh.domain.Person;
import com.qiaogh.validate.PersonValidator;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ConfigManageControllerAdvice {

    @InitBinder
    public void initBinder( WebDataBinder binder ) {
        binder.addCustomFormatter( new DateFormatter( "yyyy-MM-dd" ) );
        binder.setValidator( new PersonValidator() );
    }

    @ModelAttribute( "p" )
    public Person newPerson() {
        Person person = new Person();
        person.setName( "Qiaogh" );
        return person;
    }

    @ExceptionHandler( Exception.class )
    public ModelAndView error() {
        return new ModelAndView( "config/validateErrors" );
    }
}
