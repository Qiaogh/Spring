package com.qiaogh;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

@Configuration
@Import({
    Man.class,
    Women.class
})
public class AppConfig {

}
