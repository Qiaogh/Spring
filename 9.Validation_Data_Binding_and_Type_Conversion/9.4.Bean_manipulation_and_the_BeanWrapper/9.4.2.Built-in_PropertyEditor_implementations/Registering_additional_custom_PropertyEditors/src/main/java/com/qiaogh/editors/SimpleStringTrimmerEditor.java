package com.qiaogh.editors;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class SimpleStringTrimmerEditor extends StringTrimmerEditor {

    public SimpleStringTrimmerEditor() {
        super( ",", true );
    }

}
