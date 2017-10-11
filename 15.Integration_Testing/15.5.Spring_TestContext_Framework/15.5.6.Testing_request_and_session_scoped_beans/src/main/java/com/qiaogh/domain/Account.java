package com.qiaogh.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope( "session" )
public class Account {

    private String ip;

    public String getIp() {
        return ip;
    }

    @Value( "#{session.getAttribute( 'ip' )}" )
    public void setIp( String ip ) {
        this.ip = ip;
    }
}
