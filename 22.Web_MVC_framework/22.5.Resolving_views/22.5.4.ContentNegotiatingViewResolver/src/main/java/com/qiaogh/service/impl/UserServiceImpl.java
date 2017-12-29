package com.qiaogh.service.impl;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;
import org.springframework.stereotype.Service;

@Service( "userService" )
public class UserServiceImpl implements UserService {

    @Override
    public User get( String id ) {
        User user = new User();
        user.setId( id );
        user.setName( "Qiaogh" );
        user.setPassword( "123" );
        return user;
    }
}
