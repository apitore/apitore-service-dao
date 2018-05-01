package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ThreadDAO;
import com.apitore.dao.model.DBThread;


@Repository
public class ThreadDAOImpl implements ThreadDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBThread get(Long threadId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThread.class)
        .add(Restrictions.eq("threadId", threadId));
    DBThread value = (DBThread) crit.uniqueResult();
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBThread> gets(String field, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThread.class);
    crit.add(Restrictions.eq("enabled", true));
    crit.addOrder(Order.desc(field));
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    List<DBThread> list = crit.list();
    return list;
  }

  @Override
  public DBThread insert(DBThread val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBThread val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}