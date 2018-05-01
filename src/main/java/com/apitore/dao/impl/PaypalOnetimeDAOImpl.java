package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.PaypalOnetimeDAO;
import com.apitore.dao.model.DBPaypalOnetime;


@Repository
public class PaypalOnetimeDAOImpl implements PaypalOnetimeDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBPaypalOnetime get(String id) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBPaypalOnetime.class)
        .add(Restrictions.eq("id", id));
    DBPaypalOnetime value = (DBPaypalOnetime) crit.uniqueResult();
    return value;
  }


  @Override
  public DBPaypalOnetime insert(DBPaypalOnetime val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  @Override
  public void update(DBPaypalOnetime val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  @Override
  public void delete(DBPaypalOnetime val) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}