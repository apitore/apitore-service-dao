package com.apitore.dao;

import com.apitore.dao.model.DBRateLimit;


public interface RateLimitDAO {
  public DBRateLimit get(long userId, long apiId);

  public DBRateLimit insert(DBRateLimit val);
  public void update(DBRateLimit val);
}