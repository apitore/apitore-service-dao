package com.apitore.dao.service;

import com.apitore.dao.model.DBRateLimit;


public interface RateLimitService {
  public DBRateLimit get(long userId, long apiId);

  public DBRateLimit insert(DBRateLimit val);
  public void update(DBRateLimit val);
}