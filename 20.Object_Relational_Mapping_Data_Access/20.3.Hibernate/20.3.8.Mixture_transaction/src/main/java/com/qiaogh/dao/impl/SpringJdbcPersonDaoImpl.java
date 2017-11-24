package com.qiaogh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;

@Repository
public class SpringJdbcPersonDaoImpl implements PersonDao {

    private static ThreadLocal<LobHandler> LOB_HANDLER = new ThreadLocal<LobHandler>() {
        protected LobHandler initialValue() {
            DefaultLobHandler lobHandler = new DefaultLobHandler();
            lobHandler.setStreamAsLob( true );
            return lobHandler;
        };
    };
    
    private JdbcOperations jdbcTemplate;

    @Override
    public void save( final Person person ) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int result = this.jdbcTemplate.update( new PreparedStatementCreator() {
            
            @Override
            public PreparedStatement createPreparedStatement( Connection con ) throws SQLException {
                PreparedStatement ps = con.prepareStatement(
                        "insert into persons(name, age, data) values (?, ?, ?)",
                        new String[] { "id" } );
                ps.setString( 1, person.getName() );
                ps.setInt( 2, person.getAge() );
                LOB_HANDLER.get().getLobCreator().setClobAsString( ps, 3, person.getData() );
                return ps;
            }
        }, keyHolder );
        
        Validate.isTrue( result == 1, "保存人员信息失败！" );
    }

    public JdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate( JdbcOperations jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
