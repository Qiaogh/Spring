package com.qiaogh.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.qiaogh.domain.Time;
import com.qiaogh.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping( "/system" )
public class SystemController {

    private SystemService systemService;

    @RequestMapping( "/get" )
    @JsonView( Time.Json.class )
    public DeferredResult<Time> get( String id ) {
        return systemService.get( id );
    }

    @Autowired
    public void setSystemService( SystemService systemService ) {
        this.systemService = systemService;
    }
}
