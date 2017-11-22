package com.qiaogh.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterUtils;
import org.springframework.jdbc.core.namedparam.ParsedSql;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;

@Repository
public class SpringJdbcPersonDaoImpl implements PersonDao {

    private static ThreadLocal<RowMapper<Person>> ROW_MAPPER = new ThreadLocal<RowMapper<Person>>() {
        protected RowMapper<Person> initialValue() {
            return new PersonRowMapper();
        };
    };
    
    private static ThreadLocal<LobHandler> LOB_HANDLER = new ThreadLocal<LobHandler>() {
        protected LobHandler initialValue() {
            DefaultLobHandler lobHandler = new DefaultLobHandler();
            lobHandler.setStreamAsLob( true );
            return lobHandler;
        };
    };
    
    private static class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow( ResultSet rs, int rowNum ) throws SQLException {
            Person person = new Person();
            person.setId( rs.getInt( "id" ) );
            person.setName( rs.getString( "name" ) );
            person.setAge( rs.getInt( "age" ) );
            person.setData( LOB_HANDLER.get().getClobAsString( rs, "data" ) );
            return person;
        }
    }
    
    private JdbcOperations jdbcTemplate;

    @Override
    public int count() {
        return this.jdbcTemplate.queryForObject( "select count(*) from persons", Integer.class );
    }

    @Override
    public Integer save( final Person person ) {
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
        return keyHolder.getKey().intValue();
    }

    @Override
    public void delete( Integer id ) {
        int result = this.jdbcTemplate.update( "delete from persons where id = ?", id );
        Validate.isTrue( result == 1, "删除人员信息失败！" );
    }

    @Override
    public void update( final Person person ) {
        int result = this.jdbcTemplate.update(
                "update persons set name = ?, age = ?, data = ? where id = ?",
                new PreparedStatementSetter() {
            
            @Override
            public void setValues( PreparedStatement ps ) throws SQLException {
                ps.setString( 1, person.getName() );
                ps.setInt( 2, person.getAge() );
                LOB_HANDLER.get().getLobCreator().setClobAsString( ps, 3, person.getData() );
                ps.setInt( 4, person.getId() );
            }
        });
        Validate.isTrue( result == 1, "更新人员信息失败！" );
    }

    @Override
    public Person get( Integer id ) {
        return this.jdbcTemplate.queryForObject(
                "select id, name, age, data from persons where id = ?",
                new Object[] { id }, ROW_MAPPER.get() );
    }

    @Override
    public List<Person> query() {
        return this.jdbcTemplate.query( "select id, name, age, data from persons", ROW_MAPPER.get() );
    }
    
    @Override
    public List<Person> query( final Integer... ids ) {
        PreparedStatementCreator preparedStatementCreator = getPreparedStatementCreator(
                "select id, name, age, data from persons where id in (:ids)",
                new MapSqlParameterSource( "ids", Arrays.asList( ids ) ));
        return this.jdbcTemplate.query( preparedStatementCreator, ROW_MAPPER.get() );
    }
    
    /**
     * 摘自 Spring org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate 4.3.7.RELEASE
     * @param sql
     * @param paramSource
     * @return
     */
    protected PreparedStatementCreator getPreparedStatementCreator( String sql, SqlParameterSource paramSource ) {
        ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement( sql );
        String sqlToUse = NamedParameterUtils.substituteNamedParameters( parsedSql, paramSource );
        Object[] params = NamedParameterUtils.buildValueArray( parsedSql, paramSource, null );
        List<SqlParameter> declaredParameters = NamedParameterUtils.buildSqlParameterList( parsedSql, paramSource );
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory( sqlToUse, declaredParameters );
        return pscf.newPreparedStatementCreator( params );
    }
    
    public JdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate( JdbcOperations jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
