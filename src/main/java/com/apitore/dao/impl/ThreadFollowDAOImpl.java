package com.apitore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ThreadFollowDAO;
import com.apitore.dao.model.DBThread;
import com.apitore.dao.model.DBThreadFollow;


@Repository
public class ThreadFollowDAOImpl implements ThreadFollowDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBThreadFollow get(Long userId, Long threadId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThreadFollow.class)
        .add(Restrictions.eq("userId", userId))
        .add(Restrictions.eq("threadId", threadId));
    DBThreadFollow value = (DBThreadFollow) crit.uniqueResult();
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBThread> getsByUserId(Long userId, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThreadFollow.class);
    crit.add(Restrictions.eq("userId", userId));
    crit.addOrder(Order.desc("updatedAt"));
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBThreadFollow> list = crit.list();
    List<DBThread> rtn = new ArrayList<DBThread>();
    for (DBThreadFollow tmp: list) {
      rtn.add(new DBThread(tmp.getThreadInfo()));
    }
    return rtn;
  }

  @Override
  public DBThreadFollow insert(DBThreadFollow val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBThreadFollow val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}