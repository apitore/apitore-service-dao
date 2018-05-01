package com.apitore.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ApiDetailsDAO;
import com.apitore.dao.model.DBApiDetails;


@Repository
public class ApiDetailsDAOImpl implements ApiDetailsDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBApiDetails get(long apiId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiDetails.class)
        .add(Restrictions.eq("apiId", apiId));
    DBApiDetails value = (DBApiDetails) crit.uniqueResult();
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApiDetails> getApiDetails_GT_Date(Date from) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiDetails.class)
        .add(Restrictions.gt("lastUpdatedAt", from))
        .addOrder(Order.asc("lastUpdatedAt"));
    List<DBApiDetails> list = crit.list();
    return list;
  }

  @Override
  public DBApiDetails insert(DBApiDetails val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBApiDetails val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}