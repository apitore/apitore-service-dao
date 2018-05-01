package com.apitore.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.FollowDAO;
import com.apitore.dao.model.DBFollow;
import com.apitore.dao.model.DBUserInfo;


@Repository
public class FollowDAOImpl implements FollowDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBFollow get(Long fromId, Long toId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBFollow.class)
        .add(Restrictions.eq("fromId", fromId))
        .add(Restrictions.eq("toId", toId));
    DBFollow value = (DBFollow) crit.uniqueResult();
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBUserInfo> getsByFromId(Long fromId, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBFollow.class);
    crit.add(Restrictions.eq("fromId", fromId));
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBFollow> list = crit.list();
    List<DBUserInfo> rtn = new ArrayList<DBUserInfo>();
    for (DBFollow fact:list) {
      rtn.add(new DBUserInfo(fact.getToInfo()));
    }
    return rtn;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBUserInfo> getsByToId(Long toId, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBFollow.class);
    crit.add(Restrictions.eq("toId", toId));
    crit.setFirstResult(offset);
    crit.setMaxResults(limit);
    List<DBFollow> list = crit.list();
    List<DBUserInfo> rtn = new ArrayList<DBUserInfo>();
    for (DBFollow fact:list) {
      rtn.add(new DBUserInfo(fact.getFromInfo()));
    }
    return rtn;
  }

  @Override
  public DBFollow insert(DBFollow val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBFollow val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }

  @Override
  public void delete(DBFollow val) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(val);
  }

  @Override
  public long countByFromId(Long fromId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBFollow.class)
        .add(Restrictions.eq("fromId", fromId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }

  @Override
  public long countByToId(Long toId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBFollow.class)
        .add(Restrictions.eq("toId", toId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}