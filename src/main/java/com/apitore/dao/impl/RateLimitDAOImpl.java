package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.RateLimitDAO;
import com.apitore.dao.model.DBRateLimit;


@Repository
public class RateLimitDAOImpl implements RateLimitDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBRateLimit get(long userId, long apiId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBRateLimit.class)
        .add(Restrictions.eq("userId", userId))
        .add(Restrictions.eq("apiId", apiId));
    DBRateLimit val = (DBRateLimit) crit.uniqueResult();
    return val;
  }

  @Override
  public DBRateLimit insert(DBRateLimit val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBRateLimit val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}