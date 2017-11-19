package com.qiaogh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;

@Repository
public class SpringJdbcPersonDaoImpl implements PersonDao {

    private JdbcOperations jdbcTemplate;
    private SimpleJdbcInsertOperations jdbcInsert;
    private SqlQuery<Person> getSql;
    private SqlQuery<Person> querySql;
    private SqlUpdate sqlUpdate;

    @Override
    public int count() {
        return this.jdbcTemplate.queryForObject( "select count(*) from persons", Integer.class );
    }

    @Override
    public Integer save( Person person ) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource( person );
        return jdbcInsert.executeAndReturnKey( parameterSource ).intValue();
    }

    @Override
    public void delete( Integer id ) {
        int result = this.jdbcTemplate.update( "delete from persons where id = ?", id );
        Validate.isTrue( result == 1, "删除人员信息失败！" );
    }

    @Override
    public void update( Person person ) {
        int result = this.sqlUpdate.update( person.getName(), person.getAge(), person.getId() );
        Validate.isTrue( result == 1, "更新人员信息失败！" );
    }

    @Override
    public Person get( Integer id ) {
        return getSql.findObject( id );
    }

    @Override
    public List<Person> query() {
        return querySql.execute();
    }
    
    public JdbcOperations getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate( JdbcOperations jdbcTemplate ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SimpleJdbcInsertOperations getJdbcInsert() {
        return jdbcInsert;
    }

    @Autowired
    public void setJdbcInsert( SimpleJdbcInsertOperations jdbcInsert ) {
        this.jdbcInsert = jdbcInsert;
    }

    public SqlQuery<Person> getGetSql() {
        return getSql;
    }

    @Resource( name = "getSqlQuery" )
    public void setGetSql( SqlQuery<Person> getSql ) {
        this.getSql = getSql;
    }

    public SqlQuery<Person> getQuerySql() {
        return querySql;
    }

    @Resource( name = "querySqlQuery" )
    public void setQuerySql( SqlQuery<Person> querySql ) {
        this.querySql = querySql;
    }

    public SqlUpdate getSqlUpdate() {
        return sqlUpdate;
    }

    @Autowired
    public void setSqlUpdate( SqlUpdate sqlUpdate ) {
        this.sqlUpdate = sqlUpdate;
    }
}
