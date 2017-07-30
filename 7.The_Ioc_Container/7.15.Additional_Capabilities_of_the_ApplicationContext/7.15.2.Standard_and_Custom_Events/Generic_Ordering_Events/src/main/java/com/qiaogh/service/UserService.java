package com.qiaogh.service;

import java.util.List;

import com.qiaogh.domain.User;

public interface UserService extends List<User> {

    void save( User user );
}
