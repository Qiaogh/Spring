package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping( "/controller" )
public class MvcUriComponentsBuilderController {

    @ModelAttribute( "fromController" )
    public UriComponents fromController() {
        UriComponents uriComponents = MvcUriComponentsBuilder.fromController( MvcUriComponentsBuilderController.class )
                .build();
        return uriComponents;
    }

    @ModelAttribute( "fromMethodName" )
    public UriComponents fromMethodName() {
        UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodName(
                MvcUriComponentsBuilderController.class,
                "build" ).build();
        return uriComponents;
    }

    @ModelAttribute( "fromMethodCall" )
    public UriComponents fromMethodCall() {
        UriComponents uriComponents = MvcUriComponentsBuilder.fromMethodCall(
                MvcUriComponentsBuilder.on(
                        MvcUriComponentsBuilderController.class )
                        .build() )
                .build();
        return uriComponents;
    }

    @RequestMapping( "/build" )
    public ModelAndView build() {
        return new ModelAndView( "build" );
    }
}
