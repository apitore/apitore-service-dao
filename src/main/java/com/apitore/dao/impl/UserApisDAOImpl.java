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

import com.apitore.dao.UserApisDAO;
import com.apitore.dao.model.DBUserApis;


@Repository
public class UserApisDAOImpl implements UserApisDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<DBUserApis> getUserApis_Desc(long userId, String field, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserApis.class)
        .add(Restrictions.eq("userId", userId))
        .add(Restrictions.eq("enabled", true))
        .addOrder(Order.desc(field))
        .setFirstResult(offset)
        .setMaxResults(limit);
    List<DBUserApis> list = crit.list();
    return list;
  }

  @Override
  public DBUserApis getUserApis(long userId, long apiId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserApis.class)
        .add(Restrictions.eq("userId", userId))
        .add(Restrictions.eq("apiId", apiId));
    DBUserApis val = (DBUserApis) crit.uniqueResult();
    return val;
  }

  @Override
  public DBUserApis insert(DBUserApis val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUserApis val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }

  @Override
  public long count(Long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserApis.class)
        .add(Restrictions.eq("userId", userId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }


}