package com.qiaogh.service;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.Transactional;

import com.qiaogh.service.impl.PersonServiceImpl;

@Transactional( readOnly = true )
public class ReadOnlyPersonService extends PersonServiceImpl implements PersonService {
    
    public ReadOnlyPersonService( DataSource dataSource ) {
        setDataSource( dataSource );
    }
}
