package com.qiaogh.domain;

public class Qiaogh {
    
    // install the instance
    private static final Qiaogh instance = new Qiaogh( "Qiaogh" );
    
    // return the instance
    public static Qiaogh getInstance() {
        return instance;
    }

    private String name;
    
    private Qiaogh( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}
