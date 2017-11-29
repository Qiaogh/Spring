package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.qiaogh.domain.Person;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/testJson" )
    public ModelAndView testJson( @RequestBody String body ) {
        ModelAndView mv = new ModelAndView();
        mv.addAllObjects( JSON.parseObject( body ) );
        mv.setViewName( "config/testJson" );
        return mv;
    }
    
    @RequestMapping( "/testXml" )
    public ModelAndView testXml( @RequestBody Person person ) {
        ModelAndView mv = new ModelAndView( "config/testXml" );
        return mv;
    }
}
