package com.qiaogh.exception;

public class CannotFindObjectException extends RuntimeException {

    private static final long serialVersionUID = 5297604197120055244L;

    private Object source;

    public CannotFindObjectException( Object source ) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public void setSource( Object source ) {
        this.source = source;
    }
}
