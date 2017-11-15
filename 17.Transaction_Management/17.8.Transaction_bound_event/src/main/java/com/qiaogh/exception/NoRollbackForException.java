package com.qiaogh.exception;

@SuppressWarnings( "serial" )
public class NoRollbackForException extends RuntimeException {

    public NoRollbackForException() {}
    
    public NoRollbackForException( Throwable e ) {
        super( e );
    }
}
