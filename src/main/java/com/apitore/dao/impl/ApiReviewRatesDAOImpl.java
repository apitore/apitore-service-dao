package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ApiReviewRatesDAO;
import com.apitore.dao.model.DBApiReviewRates;


@Repository
public class ApiReviewRatesDAOImpl implements ApiReviewRatesDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBApiReviewRates get(long apiId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiReviewRates.class)
        .add(Restrictions.eq("apiId", apiId));
    DBApiReviewRates value = (DBApiReviewRates) crit.uniqueResult();
    return value;
  }


  @Override
  public DBApiReviewRates insert(DBApiReviewRates val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  @Override
  public void update(DBApiReviewRates val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}