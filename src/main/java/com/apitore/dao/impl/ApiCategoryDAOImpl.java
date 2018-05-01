package com.apitore.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ApiCategoryDAO;
import com.apitore.dao.model.DBApiCategory;


@Repository
public class ApiCategoryDAOImpl implements ApiCategoryDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBApiCategory get(Long apiId, Long categoryId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiCategory.class)
        .add(Restrictions.eq("apiId", apiId))
        .add(Restrictions.eq("categoryId", categoryId));
    DBApiCategory value = (DBApiCategory) crit.uniqueResult();
    return value;
  }


  @Override
  public DBApiCategory insert(DBApiCategory val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  @Override
  public void update(DBApiCategory val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  @Override
  public void delete(DBApiCategory val) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(val);
  }


  @Override
  public long count(Long apiId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiCategory.class)
        .add(Restrictions.eq("apiId", apiId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}