package com.qiaogh.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.qiaogh.exception.RollbackForException;

public class TransactionManageAdvice {
    
    private final PlatformTransactionManager transactionManager;
    
    public TransactionManageAdvice( PlatformTransactionManager transactionManager ) {
        this.transactionManager = transactionManager; 
    }
    
    public Object around( final ProceedingJoinPoint point ) {
        Object rel = null;
        TransactionDefinition definition = new DefaultTransactionDefinition( TransactionDefinition.PROPAGATION_REQUIRED );
        transactionManager.getTransaction( definition );
        
        TransactionStatus status = transactionManager.getTransaction( definition );
        try {
            rel = point.proceed();
        } catch ( Throwable e ) {
            if ( e instanceof RollbackForException ) {
                transactionManager.rollback( status );
            }
            throw (RuntimeException)e;
        }
        transactionManager.commit( status );
        return rel;
    }
}
