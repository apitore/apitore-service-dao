package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ThreadCategoryDAO;
import com.apitore.dao.model.DBThreadCategory;


@Repository
public class ThreadCategoryDAOImpl implements ThreadCategoryDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBThreadCategory get(Long threadId, Long categoryId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThreadCategory.class)
        .add(Restrictions.eq("threadId", threadId))
        .add(Restrictions.eq("categoryId", categoryId));
    DBThreadCategory value = (DBThreadCategory) crit.uniqueResult();
    return value;
  }


  @Override
  public DBThreadCategory insert(DBThreadCategory val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  @Override
  public void update(DBThreadCategory val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  @Override
  public void delete(DBThreadCategory val) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(val);
  }


  @Override
  public long count(Long threadId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBThreadCategory.class)
        .add(Restrictions.eq("threadId", threadId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}