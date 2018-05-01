package com.apitore.dao.service;

import com.apitore.dao.model.DBTwitterOauth;


public interface TwitterOauthService {
  public DBTwitterOauth get(Long userId);

  public DBTwitterOauth insert(DBTwitterOauth val);
  public void update(DBTwitterOauth val);
  public void delete(DBTwitterOauth val);
}