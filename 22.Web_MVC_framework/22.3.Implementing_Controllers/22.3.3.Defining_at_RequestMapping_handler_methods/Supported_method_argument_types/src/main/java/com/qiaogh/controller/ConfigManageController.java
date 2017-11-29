package com.qiaogh.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Locale;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/view" )
    public ModelAndView view(
            ServletRequest request,
            HttpSession session,
            WebRequest webRequest,
            Locale locale,
            InputStream in,
            Reader reader,
            OutputStream os,
            Writer writer,
            UriComponentsBuilder uriComponentsBuilder) {
        ModelAndView mv = new ModelAndView()
            .addObject( "request", request )
            .addObject( "session", session )
            .addObject( "webRequest", webRequest )
            .addObject( "locale", locale )
            .addObject( "in", in )
            .addObject( "reader", reader )
            .addObject( "os", os )
            .addObject( "writer", writer )
            .addObject( "uriComponentsBuilder", uriComponentsBuilder );
        mv.setViewName( "config/view" );
        return mv;
    }
}
