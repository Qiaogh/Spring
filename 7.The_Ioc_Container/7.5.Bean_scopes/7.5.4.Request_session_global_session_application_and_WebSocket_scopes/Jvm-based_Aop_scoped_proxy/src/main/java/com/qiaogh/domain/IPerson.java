package com.qiaogh.domain;

public interface IPerson {
    public String getId();
    public void setId( String id );
    public String getName();
    public void setName( String name );
    public IPerson getRequest();
    public void setRequest( IPerson request );
}
