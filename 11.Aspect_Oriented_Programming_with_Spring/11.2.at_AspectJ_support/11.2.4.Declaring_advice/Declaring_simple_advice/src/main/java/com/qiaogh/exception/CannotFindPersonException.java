package com.qiaogh.exception;

public class CannotFindPersonException extends RuntimeException {
    
    private static final long serialVersionUID = -1937844866967479923L;
    
    private String id;

    public CannotFindPersonException( String id ) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }

    public void setId( String id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CannotFindPersonException [id=" + id + "]";
    }
}
