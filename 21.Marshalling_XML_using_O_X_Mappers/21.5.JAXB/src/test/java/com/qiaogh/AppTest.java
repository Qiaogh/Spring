package com.qiaogh;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.Settings;

/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( classes = AppConfig.class )
public class AppTest {

    private static final String FILE_NAME = "settings.xml";
    private Settings settings = new Settings();

    @Autowired
    private Marshaller marshaller;

    @Autowired
    private Unmarshaller unmarshaller;

    @Test
    public void saveSettings() throws IOException {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream( FILE_NAME );
            this.marshaller.marshal( settings, new StreamResult( os ) );
        } finally {
            if ( os != null ) {
                os.close();
            }
        }
    }

    @Test
    public void loadSettings() throws IOException {
        FileInputStream is = null;
        try {
            is = new FileInputStream( FILE_NAME );
            StreamSource source = new StreamSource( is );
            this.settings = (Settings) this.unmarshaller.unmarshal( source );
        } finally {
            if ( is != null ) {
                is.close();
            }
        }
    }
}
