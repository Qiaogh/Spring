package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ServletUriComponentsBuilderController {

    @ModelAttribute( "fromRequest" )
    public UriComponents fromRequest( HttpServletRequest request ) {
        UriComponents uriComponents = ServletUriComponentsBuilder.fromRequest( request )
                .replaceQueryParam( "name", "Qgh" )
                .replaceQueryParam( "password", "321" )
                .build();
        return uriComponents;
    }

    @ModelAttribute( "fromContextPath" )
    public UriComponents fromContextPath( HttpServletRequest request ) {
        UriComponents uriComponents = ServletUriComponentsBuilder.fromContextPath( request )
                .path( "/login" )
                .build();
        return uriComponents;
    }

    @RequestMapping( "/build" )
    public ModelAndView build() {
        return new ModelAndView( "build" );
    }
}
