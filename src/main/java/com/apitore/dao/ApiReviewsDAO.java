package com.apitore.dao;

import java.util.Date;
import java.util.List;

import com.apitore.dao.model.DBApiReviews;


public interface ApiReviewsDAO {
  public List<DBApiReviews> getApiReviews(long apiId, String version, int offset, int limit);
  public List<DBApiReviews> getApiReviewsAll(long apiId, int offset, int limit);
  public DBApiReviews getApiReview(long apiId, long userId, String version);

  public List<DBApiReviews> getApiReviews_GT_Date(Date from);

  public long count(long apiId, String version, Integer rate);
  public long count(long apiId, Integer rate);

  public DBApiReviews insert(DBApiReviews val);

  //public void countApiReviews(long apiId, String version, int offset, int limit);
}