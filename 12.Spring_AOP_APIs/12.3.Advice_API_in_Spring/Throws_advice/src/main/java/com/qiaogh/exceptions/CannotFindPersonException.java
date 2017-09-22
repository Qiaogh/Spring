package com.qiaogh.exceptions;

@SuppressWarnings( "serial" )
public class CannotFindPersonException extends RuntimeException {

    private String id;
    
    public CannotFindPersonException( String id, String message ) {
        super( message );
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }
}
