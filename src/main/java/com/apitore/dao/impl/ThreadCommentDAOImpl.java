package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ThreadCommentDAO;
import com.apitore.dao.model.DBThreadComment;


@Repository
public class ThreadCommentDAOImpl implements ThreadCommentDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBThreadComment get(Long commentId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThreadComment.class);
    crit.add(Restrictions.eq("commentId", commentId));
    DBThreadComment rtn = (DBThreadComment) crit.uniqueResult();
    return rtn;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBThreadComment> gets_OrderParentId(Long threadId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThreadComment.class);
    crit.add(Restrictions.eq("threadId", threadId));
    crit.addOrder(Order.asc("parentId"));
    crit.addOrder(Order.asc("registeredAt"));
    List<DBThreadComment> list = crit.list();
    return list;
  }

  @Override
  public DBThreadComment insert(DBThreadComment val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBThreadComment val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }

  @Override
  public long count_byThreadId(Long threadId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThreadComment.class)
        .add(Restrictions.eq("threadId", threadId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}