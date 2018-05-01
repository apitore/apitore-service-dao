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

import com.apitore.dao.UserActivateDAO;
import com.apitore.dao.model.DBUserActivate;


@Repository
public class UserActivateDAOImpl implements UserActivateDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<DBUserActivate> getNewAccountNotEnabled() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserActivate.class)
        .add(Restrictions.isNull("userId"))
        .add(Restrictions.eq("enabled", false))
        .addOrder(Order.asc("registeredAt"));
    List<DBUserActivate> list = crit.list();
    return list;
  }

  @Override
  public DBUserActivate get(String username) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserActivate.class)
        .add(Restrictions.eq("username", username));
    DBUserActivate value = (DBUserActivate) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUserActivate insert(DBUserActivate val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUserActivate val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }

  @Override
  public void delete(DBUserActivate val) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(val);
  }

  @Override
  public long count() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserActivate.class)
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}