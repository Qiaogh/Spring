package com.qiaogh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping( "/config" )
public class ConfigManageController {

    @RequestMapping( "/testString/{value}" )
    @ResponseBody
    public String testString( @PathVariable String value ) {
        return value;
    }
}
