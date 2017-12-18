package com.qiaogh.service.impl;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service( "userService" )
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger( UserServiceImpl.class );

    public User getByName( String name ) {
        User user = new User();
        user.setId( Integer.MAX_VALUE );
        user.setName( name );
        user.setPassword( "123" );
        user.setAge( 26 );

        LOGGER.info( "用户登录成功！用户信息：", new Object[] { user } );
        return user;
    }
}
