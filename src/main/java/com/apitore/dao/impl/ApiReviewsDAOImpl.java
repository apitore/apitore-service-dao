package com.apitore.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apitore.dao.ApiReviewsDAO;
import com.apitore.dao.model.DBApiReviews;


@Repository
public class ApiReviewsDAOImpl implements ApiReviewsDAO {

  @Autowired
  private SessionFactory sessionFactory;


  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<DBApiReviews> getApiReviews(long apiId, String version, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiReviews.class)
        .add(Restrictions.eq("apiId", apiId))
        .add(Restrictions.eq("version", version))
        .addOrder(Order.desc("registeredAt"))
        .setFirstResult(offset)
        .setMaxResults(limit);
    List<DBApiReviews> list = crit.list();
    return list;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApiReviews> getApiReviewsAll(long apiId, int offset, int limit) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiReviews.class)
        .add(Restrictions.eq("apiId", apiId))
        .addOrder(Order.desc("registeredAt"))
        .setFirstResult(offset)
        .setMaxResults(limit);
    List<DBApiReviews> list = crit.list();
    return list;
  }

  @Override
  public DBApiReviews getApiReview(long apiId, long userId, String version) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiReviews.class)
        .add(Restrictions.eq("apiId", apiId))
        .add(Restrictions.eq("userId", userId))
        .add(Restrictions.eq("version", version));
    DBApiReviews value = (DBApiReviews) crit.uniqueResult();
    return value;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<DBApiReviews> getApiReviews_GT_Date(Date from) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiReviews.class)
        .add(Restrictions.gt("registeredAt", from))
        .addOrder(Order.asc("registeredAt"));
    List<DBApiReviews> list = crit.list();
    return list;
  }

  @Override
  public long count(long apiId, String version, Integer rate) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiReviews.class)
        .add(Restrictions.eq("apiId", apiId))
        .add(Restrictions.eq("version", version))
        .add(Restrictions.eq("rate", rate))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }

  @Override
  public long count(long apiId, Integer rate) {
    Session session = sessionFactory.getCurrentSession();
    Criteria crit = session.createCriteria(DBApiReviews.class)
        .add(Restrictions.eq("apiId", apiId))
        .add(Restrictions.eq("rate", rate))
        .setProjection(Projections.rowCount());
    Number count = (Number) crit.uniqueResult();
    return count.longValue();
  }

  @Override
  public DBApiReviews insert(DBApiReviews val) {
    Session session = sessionFactory.getCurrentSession();
    session.persist(val);
    session.flush();
    return val;
  }


  protected Session openSession() {
    return sessionFactory.openSession();
  }

}