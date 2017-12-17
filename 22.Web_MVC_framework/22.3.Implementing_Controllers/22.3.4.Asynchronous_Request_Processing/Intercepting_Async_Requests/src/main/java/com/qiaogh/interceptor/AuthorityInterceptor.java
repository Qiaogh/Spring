package com.qiaogh.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityInterceptor implements AsyncHandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger( AuthorityInterceptor.class );

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        LOGGER.info( "preHandle" );
        return true;
    }

    @Override
    public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView ) throws Exception {
        LOGGER.info( "postHandle" );
    }

    @Override
    public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex ) throws Exception {
        LOGGER.info( "afterCompletion" );
    }

    @Override
    public void afterConcurrentHandlingStarted( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        LOGGER.info( "afterConcurrentHandlingStarted" );
    }
}
