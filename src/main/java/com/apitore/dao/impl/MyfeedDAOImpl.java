package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.MyfeedDAO;
import com.apitore.dao.model.DBMyfeed;


@Repository
public class MyfeedDAOImpl implements MyfeedDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBMyfeed get(Long feedId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBMyfeed.class)
        .add(Restrictions.eq("feedId", feedId));
    DBMyfeed value = (DBMyfeed) crit.uniqueResult();
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBMyfeed> getsByUserId(Long userId, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBMyfeed.class);
    crit.add(Restrictions.eq("userId", userId));
    crit.addOrder(Order.desc("registeredAt"));
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBMyfeed> list = crit.list();
    return list;
  }

  @Override
  public DBMyfeed insert(DBMyfeed val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBMyfeed val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}