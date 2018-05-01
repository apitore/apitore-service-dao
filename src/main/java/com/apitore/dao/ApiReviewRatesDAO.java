package com.apitore.dao;

import com.apitore.dao.model.DBApiReviewRates;


public interface ApiReviewRatesDAO {
  public DBApiReviewRates get(long apiId);

  public DBApiReviewRates insert(DBApiReviewRates val);
  public void update(DBApiReviewRates val);
}