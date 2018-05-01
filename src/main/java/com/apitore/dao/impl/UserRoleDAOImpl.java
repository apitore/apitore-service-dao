package com.apitore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UserRoleDAO;
import com.apitore.dao.model.DBUserRole;


@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBUserRole insert(DBUserRole val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}