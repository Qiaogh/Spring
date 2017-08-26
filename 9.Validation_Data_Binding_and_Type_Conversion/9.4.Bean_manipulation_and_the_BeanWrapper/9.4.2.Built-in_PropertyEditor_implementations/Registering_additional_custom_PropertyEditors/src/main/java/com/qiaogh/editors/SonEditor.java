package com.qiaogh.editors;

import java.beans.PropertyEditorSupport;

import com.qiaogh.domain.Son;

public class SonEditor extends PropertyEditorSupport {

    @Override
    public void setAsText( String text ) throws IllegalArgumentException {
        setValue( new Son( text ) );
    }
    
    @Override
    public String getAsText() {
        return getValue().toString();
    }
}
