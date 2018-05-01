package com.apitore.dao.service;

import java.util.List;

import com.apitore.dao.model.DBUserActivate;


public interface UserActivateService {
  public List<DBUserActivate> getNewAccountNotEnabled();
  public DBUserActivate get(String username);

  public DBUserActivate insert(DBUserActivate val);
  public void update(DBUserActivate val);
  public void delete(DBUserActivate val);

  public long count();
}