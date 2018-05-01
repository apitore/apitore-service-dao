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

import com.apitore.dao.ApiDAO;
import com.apitore.dao.model.DBApi;


@Repository
public class ApiDAOImpl implements ApiDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<DBApi> getApis_Enabled_Desc(String[] fields, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class);
    crit.add(Restrictions.eq("enabled", true));
    crit.add(Restrictions.eq("open", true));
    for (String field: fields) {
      crit.addOrder(Order.desc(field));
    }
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBApi> list = crit.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApi> getApis_Enabled_Free_Desc(String[] fields, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class);
    crit.add(Restrictions.eq("enabled", true));
    crit.add(Restrictions.eq("open", true));
    crit.add(Restrictions.eq("royalty",0L));
    for (String field: fields) {
      crit.addOrder(Order.desc(field));
    }
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBApi> list = crit.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApi> getApis_Enabled_Paid_Desc(String[] fields, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class);
    crit.add(Restrictions.eq("enabled", true));
    crit.add(Restrictions.eq("open", true));
    crit.add(Restrictions.ne("royalty",0L));
    for (String field: fields) {
      crit.addOrder(Order.desc(field));
    }
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBApi> list = crit.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApi> getApis_DevId_Desc_Public(long devId, String[] fields, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class);
    crit.add(Restrictions.eq("devId", devId));
    crit.add(Restrictions.eq("anonymous", false));
    for (String field: fields) {
      crit.addOrder(Order.desc(field));
    }
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBApi> list = crit.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApi> getApis_UserId_Desc_Public(long userId, String[] fields, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class);
    crit.add(Restrictions.eq("userId", userId));
    crit.add(Restrictions.eq("anonymous", false));
    for (String field: fields) {
      crit.addOrder(Order.desc(field));
    }
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBApi> list = crit.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApi> getApis_UserId_Desc_Private(long userId, String[] fields, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class);
    crit.add(Restrictions.eq("userId", userId));
    for (String field: fields) {
      crit.addOrder(Order.desc(field));
    }
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBApi> list = crit.list();
    return list;
  }

  @Override
  public DBApi getApi(long apiId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class)
        .add(Restrictions.eq("apiId", apiId));
    DBApi value = (DBApi) crit.uniqueResult();
    return value;
  }

  @Override
  public DBApi insert(DBApi val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBApi val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }

  @Override
  public long countByDevId(Long devId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class)
        .add(Restrictions.eq("devId", devId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }

  @Override
  public long countByUserId(Long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApi.class)
        .add(Restrictions.eq("userId", userId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}