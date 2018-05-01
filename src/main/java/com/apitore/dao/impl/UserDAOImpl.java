package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UserDAO;
import com.apitore.dao.model.DBUser;
import com.apitore.dao.model.DBUserSimple;


@Repository
public class UserDAOImpl implements UserDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBUser getUser(String username) {
    //Session session = sessionFactory.openSession();
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUser.class)
        .add(Restrictions.eq("username", username));
    DBUser value = (DBUser) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUserSimple insert(DBUserSimple val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUserSimple val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }

  @Override
  public long count() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUser.class)
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}