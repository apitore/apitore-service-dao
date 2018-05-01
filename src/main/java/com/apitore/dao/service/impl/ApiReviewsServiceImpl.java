package com.apitore.dao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ApiReviewsDAO;
import com.apitore.dao.model.DBApiReviews;
import com.apitore.dao.service.ApiReviewsService;


@Service
public class ApiReviewsServiceImpl implements ApiReviewsService {

  @Autowired
  ApiReviewsDAO dao;


  @Override
  @Transactional(readOnly=true)
  public List<DBApiReviews> getApiReviews(long apiId, String version, int offset, int limit) {
    return dao.getApiReviews(apiId, version, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBApiReviews> getApiReviewsAll(long apiId, int offset, int limit) {
    return dao.getApiReviewsAll(apiId, offset, limit);
  }

  @Override
  @Transactional(readOnly=true)
  public DBApiReviews getApiReview(long apiId, long userId, String version) {
    return dao.getApiReview(apiId, userId, version);
  }

  @Override
  @Transactional(readOnly=true)
  public List<DBApiReviews> getApiReviews_GT_Date(Date from) {
    return dao.getApiReviews_GT_Date(from);
  }

  @Override
  @Transactional(readOnly=true)
  public long count(long apiId, String version, Integer rate) {
    return dao.count(apiId, version, rate);
  }

  @Override
  @Transactional(readOnly=true)
  public long count(long apiId, Integer rate) {
    return dao.count(apiId, rate);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBApiReviews insert(DBApiReviews val) {
    return dao.insert(val);
  }

}