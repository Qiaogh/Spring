package com.qiaogh.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface Constants {

    /**
     * 标准日期格式化日期
     */
    String STANDARD_DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    
    /**
     * 标准日期格式化
     */
    DateFormat DATE_FORMAT = new SimpleDateFormat( STANDARD_DATE_FORMAT_PATTERN );
}
