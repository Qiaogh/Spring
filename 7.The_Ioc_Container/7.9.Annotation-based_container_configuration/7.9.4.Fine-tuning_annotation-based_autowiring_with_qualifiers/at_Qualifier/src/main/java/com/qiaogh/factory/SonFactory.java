package com.qiaogh.factory;

import com.qiaogh.domain.Son;

public class SonFactory {

    public static Son qiaoxl() {
        return new Son( "qiaoxl" );
    }
    
    public static Son qiaodl() {
        return new Son( "qiaodl" );
    }
}
