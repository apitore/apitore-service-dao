package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UserInfoDAO;
import com.apitore.dao.model.DBUserInfo;


@Repository
public class UserInfoDAOImpl implements UserInfoDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<DBUserInfo> getUserInfo() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserInfo.class);
    List<DBUserInfo> list = crit.list();
    return list;
  }

  @Override
  public DBUserInfo getUserInfo(String username) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserInfo.class)
        .add(Restrictions.eq("username", username));
    DBUserInfo value = (DBUserInfo) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUserInfo getUserInfoByDisplayname(String displayname) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserInfo.class)
        .add(Restrictions.eq("displayname", displayname));
    DBUserInfo value = (DBUserInfo) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUserInfo getUserInfo(long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserInfo.class)
        .add(Restrictions.eq("userId", userId));
    DBUserInfo value = (DBUserInfo) crit.uniqueResult();
    return value;
  }

  @Override
  public DBUserInfo insert(DBUserInfo val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBUserInfo val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}