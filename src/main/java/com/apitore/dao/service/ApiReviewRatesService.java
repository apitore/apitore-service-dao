package com.apitore.dao.service;

import com.apitore.dao.model.DBApiReviewRates;


public interface ApiReviewRatesService {
  public DBApiReviewRates get(long apiId);

  public DBApiReviewRates insert(DBApiReviewRates val);
  public void update(DBApiReviewRates val);
}