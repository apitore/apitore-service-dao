package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UserThreadDAO;
import com.apitore.dao.model.DBUserThread;


@Repository
public class UserThreadDAOImpl implements UserThreadDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBUserThread get(Long threadId, Long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserThread.class)
        .add(Restrictions.eq("threadId", threadId))
        .add(Restrictions.eq("userId", userId));
    DBUserThread value = (DBUserThread) crit.uniqueResult();
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBUserThread> gets(Long userId, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserThread.class);
    crit.add(Restrictions.eq("enabled", true));
    crit.add(Restrictions.eq("userId", userId));
    crit.addOrder(Order.desc("registeredAt"));
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBUserThread> list = crit.list();
    return list;
  }

  @Override
  public DBUserThread insert(DBUserThread val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUserThread val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}