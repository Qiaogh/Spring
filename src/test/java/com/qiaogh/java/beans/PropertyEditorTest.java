package com.qiaogh.java.beans;

import java.beans.PropertyEditor;
import java.util.Properties;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.beans.propertyeditors.PropertiesEditor;

public class PropertyEditorTest {

    @Test
    public void test() {
        PropertyEditor editor = new PropertiesEditor();
        editor.setAsText( "jdbc.driver.className=com.mysql.jdbc.Driver\njdbc.url=jdbc:mysql://localhost:3306/mydb" );
        Properties prop = (Properties) editor.getValue();
        TestCase.assertEquals( "com.mysql.jdbc.Driver", prop.get( "jdbc.driver.className" ) );
        TestCase.assertEquals( "jdbc:mysql://localhost:3306/mydb", prop.get( "jdbc.url" ) );
    }
}
