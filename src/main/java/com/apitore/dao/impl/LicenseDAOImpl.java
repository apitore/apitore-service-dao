package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.LicenseDAO;
import com.apitore.dao.model.DBLicense;


@Repository
public class LicenseDAOImpl implements LicenseDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<DBLicense> get() {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBLicense.class);
    List<DBLicense> list = crit.list();
    return list;
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}