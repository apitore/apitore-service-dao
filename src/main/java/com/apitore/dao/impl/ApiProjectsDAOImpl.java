package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ApiProjectsDAO;
import com.apitore.dao.model.DBApiProjects;


@Repository
public class ApiProjectsDAOImpl implements ApiProjectsDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<DBApiProjects> getApiProjects(long projectId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiProjects.class)
        .add(Restrictions.eq("projectId", projectId));
    List<DBApiProjects> list = crit.list();
    return list;
  }

  @Override
  public DBApiProjects getApiProject(long projectId, long apiId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiProjects.class)
        .add(Restrictions.eq("projectId", projectId))
        .add(Restrictions.eq("apiId", apiId));
    DBApiProjects val = (DBApiProjects) crit.uniqueResult();
    return val;
  }

  @Override
  public DBApiProjects insert(DBApiProjects val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }

  @Override
  public void update(DBApiProjects val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }

  @Override
  public void delete(DBApiProjects val) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(val);
  }

  @Override
  public void deleteHQL(long projectId) {
    Session session = sessionFactory.getCurrentSession();
    session.createQuery("delete DBApiProjects where projectId=:projectId")
        .setLong("projectId", projectId)
        .executeUpdate();
  }


  @Override
  public long count(Long projectId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiProjects.class)
        .add(Restrictions.eq("projectId", projectId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }


}