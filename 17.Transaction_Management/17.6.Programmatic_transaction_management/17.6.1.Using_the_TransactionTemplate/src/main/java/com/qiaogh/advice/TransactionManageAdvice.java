package com.qiaogh.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.qiaogh.exception.RollbackForException;

public class TransactionManageAdvice {
    
    private final TransactionTemplate transactionTemplate;
    
    public TransactionManageAdvice( PlatformTransactionManager transactionManager ) {
        this.transactionTemplate = new TransactionTemplate( transactionManager ); 
    }
    
    public Object around( final ProceedingJoinPoint point ) {
        return this.transactionTemplate.execute( new TransactionCallback<Object>() {
            public Object doInTransaction( TransactionStatus status ) {
                Object rel = null;
                try {
                    rel = point.proceed();
                } catch ( Throwable e ) {
                    if ( e instanceof RollbackForException ) {
                        status.setRollbackOnly();
                    }
                    throw (RuntimeException) e;
                }
                return rel;
            }
        });
    }
}
