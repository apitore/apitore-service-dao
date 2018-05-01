package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.ApiReviewRatesDAO;
import com.apitore.dao.model.DBApiReviewRates;
import com.apitore.dao.service.ApiReviewRatesService;


@Service
public class ApiReviewRatesServiceImpl implements ApiReviewRatesService {

  @Autowired
  ApiReviewRatesDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBApiReviewRates get(long apiId) {
    return dao.get(apiId);
  }


  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBApiReviewRates insert(DBApiReviewRates val) {
    return dao.insert(val);
  }


  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBApiReviewRates val) {
    dao.update(val);
  }

}