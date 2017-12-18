package com.qiaogh.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {

    public static final int DEFAULT_OPENING_TIME = 9;
    public static final int DEFAULT_CLOSING_TIME = 18;

    private int openingTime = DEFAULT_OPENING_TIME;
    private int closingTime = DEFAULT_CLOSING_TIME;

    @Override
    public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get( Calendar.HOUR_OF_DAY );
        if ( openingTime < hour && hour < closingTime ) {
            return true;
        }
        response.sendRedirect( "/outsideOfficeHours.html" );
        return false;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime( int openingTime ) {
        this.openingTime = openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime( int closingTime ) {
        this.closingTime = closingTime;
    }
}
