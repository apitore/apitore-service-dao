package com.apitore.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apitore.dao.RateLimitDAO;
import com.apitore.dao.model.DBRateLimit;
import com.apitore.dao.service.RateLimitService;


@Service
public class RateLimitServiceImpl implements RateLimitService {

  @Autowired
  RateLimitDAO dao;


  @Override
  @Transactional(readOnly=true)
  public DBRateLimit get(long userId, long apiId) {
    return dao.get(userId, apiId);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public DBRateLimit insert(DBRateLimit val) {
    return dao.insert(val);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void update(DBRateLimit val) {
    dao.update(val);
  }

}