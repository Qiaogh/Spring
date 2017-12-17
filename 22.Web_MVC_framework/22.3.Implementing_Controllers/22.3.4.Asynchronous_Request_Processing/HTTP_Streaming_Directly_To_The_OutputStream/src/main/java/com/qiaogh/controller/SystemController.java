package com.qiaogh.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiaogh.domain.Time;
import com.qiaogh.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping( "/system" )
public class SystemController {

    private SystemService systemService;
    private ObjectMapper om = new ObjectMapper();

    @RequestMapping( "/get" )
    public StreamingResponseBody get( final String id ) {
        return new StreamingResponseBody() {

            @Override
            public void writeTo( OutputStream outputStream ) throws IOException {
                Time time = systemService.get( id );
                om.writeValue( outputStream, time );
            }
        };
    }

    @Autowired
    public void setSystemService( SystemService systemService ) {
        this.systemService = systemService;
    }
}
