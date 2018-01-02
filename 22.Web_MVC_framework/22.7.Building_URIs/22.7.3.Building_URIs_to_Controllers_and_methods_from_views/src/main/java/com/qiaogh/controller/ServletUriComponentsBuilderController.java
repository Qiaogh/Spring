package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping( "/controller" )
public class ServletUriComponentsBuilderController {

    @ModelAttribute( "fromMappingName" )
    public UriComponents fromMappingName() {
        String uriComponents = MvcUriComponentsBuilder.fromMappingName( "SUCBC#build" ).build();
        return UriComponentsBuilder.fromPath( uriComponents ).build();
    }

    @RequestMapping( "/build" )
    public String build() {
        return "build";
    }
}
