package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.TwitterOauthDAO;
import com.apitore.dao.model.DBTwitterOauth;


@Repository
public class TwitterOauthDAOImpl implements TwitterOauthDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBTwitterOauth get(Long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBTwitterOauth.class)
        .add(Restrictions.eq("userId", userId));
    DBTwitterOauth value = (DBTwitterOauth) crit.uniqueResult();
    return value;
  }


  @Override
  public DBTwitterOauth insert(DBTwitterOauth val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  @Override
  public void update(DBTwitterOauth val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  @Override
  public void delete(DBTwitterOauth val) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}