package com.qiaogh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( classes = AppConfig.class )
public class AppTest {
    
    @Autowired
    private Marshaller marshaller;
    
    @Autowired
    private Unmarshaller unmarshaller;
    
    @Test
    public void test() {
        
    }
}
