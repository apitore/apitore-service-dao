package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UserReportDAO;
import com.apitore.dao.model.DBUserReport;


@Repository
public class UserReportDAOImpl implements UserReportDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBUserReport get(Long apiId, Long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserReport.class)
        .add(Restrictions.eq("apiId", apiId))
        .add(Restrictions.eq("userId", userId));
    DBUserReport value = (DBUserReport) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUserReport insert(DBUserReport val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUserReport val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}