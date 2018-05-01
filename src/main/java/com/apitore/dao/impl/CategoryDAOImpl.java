package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.CategoryDAO;
import com.apitore.dao.model.DBCategory;


@Repository
public class CategoryDAOImpl implements CategoryDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBCategory get(String category) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBCategory.class)
        .add(Restrictions.eq("category", category));
    DBCategory value = (DBCategory) crit.uniqueResult();
    return value;
  }

  @Override
  public DBCategory insert(DBCategory val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}