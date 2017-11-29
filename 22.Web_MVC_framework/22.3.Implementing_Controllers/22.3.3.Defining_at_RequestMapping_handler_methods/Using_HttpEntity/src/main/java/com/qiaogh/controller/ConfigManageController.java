package com.qiaogh.controller;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/testRequest" )
    public ModelAndView testRequest( HttpEntity<String> request ) {
        ModelAndView mv = new ModelAndView( "config/testRequest" );
        mv.addAllObjects( request.getHeaders().toSingleValueMap() );
        mv.addObject( "body", request.getBody() );
        return mv;
    }
}
