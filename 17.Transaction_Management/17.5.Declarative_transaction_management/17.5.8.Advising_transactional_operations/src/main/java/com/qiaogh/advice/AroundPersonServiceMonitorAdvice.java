package com.qiaogh.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;

public class AroundPersonServiceMonitorAdvice implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger( AroundPersonServiceMonitorAdvice.class );
    
    private int order;
    
    public Object monitor( ProceedingJoinPoint point ) throws Throwable {
        StopWatch clock = new StopWatch( getClass().getName() );
        clock.start( point.toShortString() );
        Object rel = point.proceed();
        clock.stop();
        if ( LOGGER.isDebugEnabled() ) {
            LOGGER.debug( "调用情况：" + clock.prettyPrint() );
        }
        return rel;
    }

    public void setOrder( int order ) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }
}
