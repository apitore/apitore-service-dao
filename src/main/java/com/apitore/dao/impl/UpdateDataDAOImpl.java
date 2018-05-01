package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UpdateDataDAO;
import com.apitore.dao.model.DBUpdateData;


@Repository
public class UpdateDataDAOImpl implements UpdateDataDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBUpdateData get(Integer id) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUpdateData.class)
        .add(Restrictions.eq("id", id));
    DBUpdateData value = (DBUpdateData) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUpdateData insert(DBUpdateData val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUpdateData val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}