package com.qiaogh.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/httpEntity" )
    public ModelAndView httpEntity( HttpEntity<String> request ) {
        ModelAndView mv = new ModelAndView( "config/httpEntity" );
        mv.addAllObjects( request.getHeaders().toSingleValueMap() );
        mv.addObject( "body", request.getBody() );
        return mv;
    }
    
    @RequestMapping( "/responseEntity/{value}" )
    public ResponseEntity<String> responseEntity( @PathVariable String value ) {
        HttpHeaders headers = new HttpHeaders();
        headers.add( "value", value );
        return new ResponseEntity<>( headers, HttpStatus.CREATED );
    }
}
