package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UserCreditDAO;
import com.apitore.dao.model.DBUserCredits;


@Repository
public class UserCreditDAOImpl implements UserCreditDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBUserCredits get(long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserCredits.class)
        .add(Restrictions.eq("userId", userId));
    DBUserCredits value = (DBUserCredits) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUserCredits insert(DBUserCredits val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUserCredits val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}