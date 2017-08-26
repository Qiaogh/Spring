package com.qiaogh.editors;

import org.springframework.beans.propertyeditors.CustomDateEditor;

import com.qiaogh.util.DateUtil;

public class SimpleCustomDateEditor extends CustomDateEditor {

    public SimpleCustomDateEditor() {
        super( DateUtil.DATE_FORMAT, true );
    }
}
