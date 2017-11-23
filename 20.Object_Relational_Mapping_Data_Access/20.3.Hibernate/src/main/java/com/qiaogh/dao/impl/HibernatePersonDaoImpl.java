package com.qiaogh.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;

@Repository
public class HibernatePersonDaoImpl extends HibernateTemplate implements PersonDao {

    @Override
    public int count() {
        DetachedCriteria criteria = DetachedCriteria.forClass( Person.class );
        criteria.setProjection( Projections.rowCount() );
        return Integer.valueOf( String.valueOf( findByCriteria( criteria ).get( 0 ) ) );
    }

    @Override
    public Person get( Integer id ) {
        return get( Person.class, id );
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<Person> query() {
        DetachedCriteria criteria = DetachedCriteria.forClass( Person.class );
        return (List<Person>) findByCriteria( criteria );
    }

    @Override
    public List<Person> query( final Integer... ids ) {
        return execute( new HibernateCallback<List<Person>>() {

            @SuppressWarnings( "unchecked" )
            @Override
            public List<Person> doInHibernate( Session session ) throws HibernateException {
                return session.createQuery( "from Person where id in (:ids)" )
                        .setParameterList( "ids", Arrays.asList( ids ) ).list();
            }
        } );
    }

    @Override
    public Integer save( Person person ) {
        return (Integer) super.save( person );
    }

    @Override
    public void delete( Integer id ) {
        delete( get( id ) );
    }

    @Override
    public void update( Person person ) {
        super.update( person );
    }
    
    @Override
    @Autowired
    public void setSessionFactory( SessionFactory sessionFactory ) {
        super.setSessionFactory( sessionFactory );
    }
}
