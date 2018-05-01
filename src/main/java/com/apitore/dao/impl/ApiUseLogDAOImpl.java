package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ApiUseLogDAO;
import com.apitore.dao.model.DBApiUseLog;


@Repository
public class ApiUseLogDAOImpl implements ApiUseLogDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<DBApiUseLog> getApiUseLog_ByUserId(long userId, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiUseLog.class);
    crit.add(Restrictions.eq("userId", userId));
    crit.addOrder(Order.desc("accessDate"));
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBApiUseLog> list = crit.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public DBApiUseLog get_NotPaid() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiUseLog.class);
    crit.add(Restrictions.eq("paid", false));
    List<DBApiUseLog> list = crit.list();
    if (list.isEmpty())
      return null;
    else
      return list.get(0);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApiUseLog> gets_NotPaid(long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiUseLog.class);
    crit.add(Restrictions.eq("userId", userId));
    crit.add(Restrictions.eq("paid", false));
    crit.add(Restrictions.eq("success", true));
    List<DBApiUseLog> list = crit.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApiUseLog> gets_NotPaid(long apiId, long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiUseLog.class);
    crit.add(Restrictions.eq("apiId", apiId));
    crit.add(Restrictions.eq("userId", userId));
    crit.add(Restrictions.eq("paid", false));
    crit.add(Restrictions.eq("success", true));
    List<DBApiUseLog> list = crit.list();
    return list;
  }

  @Override
  public DBApiUseLog insert(DBApiUseLog val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBApiUseLog val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}