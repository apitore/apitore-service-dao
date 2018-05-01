package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UserThreadCommentDAO;
import com.apitore.dao.model.DBUserThreadComment;


@Repository
public class UserThreadCommentDAOImpl implements UserThreadCommentDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBUserThreadComment get(Long commentId, Long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserThreadComment.class)
        .add(Restrictions.eq("commentId", commentId))
        .add(Restrictions.eq("userId", userId));
    DBUserThreadComment value = (DBUserThreadComment) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUserThreadComment insert(DBUserThreadComment val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUserThreadComment val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}