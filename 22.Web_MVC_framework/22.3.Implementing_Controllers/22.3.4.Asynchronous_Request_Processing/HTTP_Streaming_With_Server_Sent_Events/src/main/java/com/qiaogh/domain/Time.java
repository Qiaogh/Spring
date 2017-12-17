package com.qiaogh.domain;

import com.fasterxml.jackson.annotation.JsonView;

public class Time {

    public class Json {}

    public Time( String time ) {
        this.time = time;
    }

    @JsonView( Json.class )
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime( String time ) {
        this.time = time;
    }
}
