package com.qiaogh.beans.propertyeditors;

import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;

/**
 * Created by qiaogh on 2017/3/11.
 */
public class DatePropertyEditor extends CustomDateEditor {

    private static final SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );

    public DatePropertyEditor() {
        super( format, true );
    }
}
