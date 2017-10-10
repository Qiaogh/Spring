package com.qiaogh;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;

@Ignore
@RunWith( SpringRunner.class )
@ContextConfiguration( classes = {
    AppConfig.class
})
public class TestConfig {

}
