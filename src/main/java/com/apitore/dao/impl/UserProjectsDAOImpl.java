package com.apitore.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.UserProjectsDAO;
import com.apitore.dao.model.DBUserProjects;


@Repository
public class UserProjectsDAOImpl implements UserProjectsDAO {

  @Autowired
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @Override
  public DBUserProjects getUserProject(long projectId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserProjects.class)
        .add(Restrictions.eq("projectId", projectId));
    DBUserProjects val = (DBUserProjects) crit.uniqueResult();
    return val;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBUserProjects> getUserProjects(long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserProjects.class)
        .add(Restrictions.eq("userId", userId));
    List<DBUserProjects> list = crit.list();
    return list;
  }


  @Override
  public DBUserProjects insert(DBUserProjects val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  @Override
  public void update(DBUserProjects val) {
    Session session = sessionFactory.getCurrentSession();
    session.update(val);
  }


  @Override
  public void delete(DBUserProjects val) {
    Session session = sessionFactory.getCurrentSession();
    session.delete(val);
  }


  @Override
  public long count(Long userId) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBUserProjects.class)
        .add(Restrictions.eq("userId", userId))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}