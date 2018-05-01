package com.apitore.dao;

import com.apitore.dao.model.DBTwitterOauth;


public interface TwitterOauthDAO {
  public DBTwitterOauth get(Long userId);

  public DBTwitterOauth insert(DBTwitterOauth val);
  public void update(DBTwitterOauth val);
  public void delete(DBTwitterOauth val);
}