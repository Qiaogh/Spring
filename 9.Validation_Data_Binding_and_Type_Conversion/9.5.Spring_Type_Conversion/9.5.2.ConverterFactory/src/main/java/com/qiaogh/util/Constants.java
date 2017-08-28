package com.qiaogh.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface Constants {

    /**
     * 标准日期格式化日期
     */
    String STANDARD_DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    /**
     * 标准时间格式化日期
     */
    String STANDARD_DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd hh:mm:ss";
    
    /**
     * 标准日期格式化
     */
    DateFormat DATE_FORMAT = new SimpleDateFormat( STANDARD_DATE_FORMAT_PATTERN );
    
    /**
     * 标准时间格式化
     */
    DateFormat DATE_TIME_FORMAT = new SimpleDateFormat( STANDARD_DATE_TIME_FORMAT_PATTERN );
}
