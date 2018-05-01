package com.apitore.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.RoleDAO;
import com.apitore.dao.model.DBRole;


@Repository
public class RoleDAOImpl implements RoleDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  public DBRole getRole(int id) {
    DBRole role = (DBRole) sessionFactory.getCurrentSession().load(DBRole.class, id);
    return role;
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}